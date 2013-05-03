/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bite.framework.server;

import de.bite.framework.context.IContext;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author nixdorfan
 */
public interface IServerHandler extends Runnable {

    void run();

    void setContext(IContext context);

    void setServerSocket(ServerSocket server);
    
    void setBasePath(String basepath);

    void setSocket(Socket cs);
    
}
