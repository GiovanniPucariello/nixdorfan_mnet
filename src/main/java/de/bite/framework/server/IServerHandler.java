/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.server.IServerHandler.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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
