/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.server;

//~--- classes ----------------------------------------------------------------

import de.bite.framework.context.IContext;
import de.bite.framework.context.extension.impl.ContextType;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author AN
 */
public class BiteServer implements Runnable {


        private int port;
        private ServerSocket server;
        private IContext context;
        ExecutorService pool;
        
        public BiteServer(int port, ExecutorService pool) throws Exception {
            this.port = port;
            this.server = new ServerSocket(this.port);
            this.pool = pool;
        }
        
        public void setContext(IContext context){
            this.context = context;
        }
        
        public ServerSocket getServerSocket(){
            return this.server;
        }
 

        @Override
        public void run() { // run the service

        try {
          //Endlos-Schleife: warte auf Client-Anforderungen
          //Abbruch durch Strg+C oder Client-Anforderung 'Exit',
          //dadurch wird der ServerSocket beendet, was hier zu einer IOException
          //fuehrt und damit zum Ende der run-Methode mit vorheriger Abarbeitung der
          //finally-Klausel.
          while ( true ) {
            
              /*
             Zunaechst wird eine Client-Anforderung entgegengenommen(accept-Methode).
             Der ExecutorService pool liefert einen Thread, dessen run-Methode
             durch die run-Methode der Handler-Instanz realisiert wird.
             Dem Handler werden als Parameter uebergeben:
             der ServerSocket und der Socket des anfordernden Clients.
            */
            Socket cs = this.server.accept();  //warten auf Client-Anforderung
            ServerHandler newServerHandler = (ServerHandler)context.getUnboundObject("default.server.handler");
            newServerHandler.setBasePath((String)this.context.getObject("basepath", ContextType.USED, null));
            newServerHandler.setSocket(cs);
            newServerHandler.setServerSocket(server);
            
            //starte den Handler-Thread zur Realisierung der Client-Anforderung
            pool.execute(newServerHandler);
          }
        } catch (IOException ex) {
          this.context.getLogger().error("--- Interrupt BiteServer-run");
        }
        finally {
          this.context.getLogger().error("--- Ende BiteServer(pool.shutdown)");
          pool.shutdown();  //keine Annahme von neuen Anforderungen
          try {
            //warte maximal 4 Sekunden auf Beendigung aller Anforderungen
            pool.awaitTermination(4L, TimeUnit.SECONDS);
            if ( !server.isClosed() ) {
              this.context.getLogger().error("--- Ende BiteServer:ServerSocket close");
              server.close();
            }
          } catch ( IOException ex ) { }
          catch ( InterruptedException ex ) { }
        }
      }
}


/* ||\
 * ---------------------------------------------------------
 */
