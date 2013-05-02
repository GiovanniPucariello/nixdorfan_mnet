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
public class ServerHandler implements Runnable {

    private IContext context;
    private Socket cs;
    private ServerSocket server;
    
    
    public void setContext(IContext context){
        this.context = context;
    }
    
    public void setSocket(Socket cs){
        this.cs = cs;
    }
    
    public void setServerSocket(ServerSocket server){
        this.server = server;
    }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
