/**
 *
 * Copyright (c) 2013.10.04
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.server;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.IContext;

//~--- JDK imports ------------------------------------------------------------

import java.net.ServerSocket;
import java.net.Socket;

//~--- interfaces -------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public interface IServerHandler extends Runnable
{
  //~--- methods --------------------------------------------------------------

  /**
   */
  void run();

  /**
   *
   * @param context IContext
   */
  void setContext(IContext context);

  /**
   *
   * @param server ServerSocket
   */
  void setServerSocket(ServerSocket server);

  /**
   *
   * @param basepath String
   */
  void setBasePath(String basepath);

  /**
   *
   * @param cs Socket
   */
  void setSocket(Socket cs);
}


/* ||\
 * ---------------------------------------------------------
 */
