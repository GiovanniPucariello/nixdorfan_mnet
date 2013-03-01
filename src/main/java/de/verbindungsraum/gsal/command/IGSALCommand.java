/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.verbindungsraum.gsal.command;

import de.bite.framework.context.IContext;
import de.verbindungsraum.gsal.exception.GSALCommandException;
import javax.swing.JFrame;
/**
 *
 * @author nixdorfan
 */
public interface IGSALCommand {
    
    public void setContext(IContext context);
    public void setCommandString(String controller_name);
    public void setGUIInforamtion(Object objectFromGUI);
    public void execute() throws GSALCommandException;
    
}
