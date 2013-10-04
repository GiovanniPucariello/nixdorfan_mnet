/**
 *
 * Copyright (c) 2013.10.04
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.server.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.context.IContext;
import de.bite.framework.controller.Controller;
import de.bite.framework.server.IServerHandler;

import de.verbindungsraum.gsal.utilities.ModulAnalyzer;

//~--- JDK imports ------------------------------------------------------------

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.concurrent.ExecutorService;
import java.util.List;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class ServerHandler implements IServerHandler
{

  //~--- fields ---------------------------------------------------------------

  private IContext     context;
  private Socket       cs;
  private ServerSocket server;
  private String       basepath;

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param context IContext
   */
  @Override
  public void setContext(IContext context)
  {
    this.context = context;
  }

  /**
   *
   * @param cs Socket
   */
  @Override
  public void setSocket(Socket cs)
  {
    this.cs = cs;
  }

  /**
   *
   * @param server ServerSocket
   */
  @Override
  public void setServerSocket(ServerSocket server)
  {
    this.server = server;
  }

  /**
   *
   * @param basepath String
   */
  @Override
  public void setBasePath(String basepath)
  {
    this.basepath = basepath;
  }

  /**
   */
  @Override
  public void run()
  {

    try
    {
      List< String > modulesToLoad = ModulAnalyzer.getActualItemsForConsole(this.basepath);

      // read and service request on client
      context.getLogger().info("ServerHandler startet service, " + Thread.currentThread());

      PrintWriter    out            = new PrintWriter(cs.getOutputStream(), true);
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cs.getInputStream()));
      char[]         buffer         = new char[1024];
      int            anzahlZeichen  = bufferedReader.read(buffer, 0, 1024);    // blockiert bis Nachricht empfangen
      String         nachricht      = new String(buffer, 0, anzahlZeichen);
      String[]       werte          = nachricht.split("\\n");

      for(int i = 0; i < werte.length; i++)
      {
        this.context.getLogger().info("URL-Wert : " + werte[i]);
      }

      // Extrahiere Befehl aus HTTP-Header
      String[] befehlszeile = werte[0].split("\\s");
      String   befehl       = befehlszeile[1].substring(1);

      // Protokolliere eingegebenen Befehl
      this.context.getLogger().info("eingegebener Befehl : " + befehl + "\n");
      out.println("eingegebener Befehl : " + befehl + " wird ausgefuehrt. ");

      if(befehl.equalsIgnoreCase("") || (befehl == null))
      {
        out.println("Bitte Befehl in Adressleiste eingeben. Befehl wird folgend ausgefuehrt ... ");
      }
      else
      {
        for(String command : modulesToLoad)
        {
          this.context.getLogger().info("Modified vorhandene Befehle : " + command + "\n");

          if(command.equalsIgnoreCase(befehl))
          {
            if(command.equalsIgnoreCase("base") || command.equalsIgnoreCase("default"))
            {
              this.context.getLogger().info("Befehl base oder default hat keinen Controller hinterlegt. Befehl war : " + command + " \n");
            }
            else
            {
              Controller controll = (Controller)context.getObject(befehl + ".controller", ContextType.NEW, null);

              controll.dispatch();
            }
          }
          else if(befehl.equalsIgnoreCase("quit"))
          {
            this.context.getLogger().info("quit detected. Starting shutdownhook");

            ExecutorService threadpool = (ExecutorService)this.context.getObject("serverthreadpool");

            threadpool.shutdownNow();
            this.context.getLogger().info("System going to be shut down ... ");
            System.exit(0);
          }
        }
      }

      out.flush();
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      throw new RuntimeException();
    }

  }
}


/* ||\
 * ---------------------------------------------------------
 */
