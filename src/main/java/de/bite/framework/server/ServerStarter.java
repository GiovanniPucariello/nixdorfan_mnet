/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bite.framework.server;

import de.bite.framework.bootstrap.impl.Bootstrap;
import de.bite.framework.bootstrap.impl.ConsoleValuesPreparator;
import de.bite.framework.context.IContext;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author nixdorfan
 */
public class ServerStarter {
    
 
  public static void main(String[] args) throws Exception {
    
    IContext context = Bootstrap.startContext(ConsoleValuesPreparator.prepare(args));
      
    final ExecutorService pool;
    final ServerSocket serverSocket;
   
    int port = 0;
    
    try{
        port = Integer.parseInt((String)context.getStringValueFromProperties("default.server.port"));
    } catch (Exception ex){ 
        port = 9001;
        context.getLogger().error("no dynamic port for internal server. use default instead ::: 9001");
    }

    
   
    //Liefert einen Thread-Pool, dem bei Bedarf neue Threads hinzugefügt
    //werden. Vorrangig werden jedoch vorhandene freie Threads benutzt.
    pool = Executors.newCachedThreadPool();
    //int poolSize = 10;
    //Liefert einen Thread-Pool für maximal poolSize Threads
    //pool = Executors.newFixedThreadPool(poolSize);

    final BiteServer server = new BiteServer(port,pool);
    server.setContext(context);
    
    //Thread zur Behandlung der Client-Server-Kommunikation, der Thread-
    //Parameter liefert das Runnable-Interface (also die run-Methode für t1).
    Thread serverworker= new Thread(server);
    
    context.getLogger().info("Starte BiteServer mit Thread: "+Thread.currentThread());
    //Start der run-Methode von NetworkService: warten auf Client-request
    serverworker.start();
//
    //reagiert auf Strg+C, der Thread(Parameter) darf nicht gestartet sein
    Runtime.getRuntime().addShutdownHook(
      new Thread() {
        public void run() {
          System.out.println("Strg+C, pool.shutdown");
          pool.shutdown();  //keine Annahme von neuen Anforderungen
          try {
            //warte maximal 4 Sekunden auf Beendigung aller Anforderungen
            pool.awaitTermination(4L, TimeUnit.SECONDS);
            if (!server.getServerSocket().isClosed()) {
              System.out.println("ServerSocket close");
              server.getServerSocket().close();
            }
          } catch ( IOException ex ) { }
          catch ( InterruptedException ex ) { }
        }
      }
    );
//
  }
}