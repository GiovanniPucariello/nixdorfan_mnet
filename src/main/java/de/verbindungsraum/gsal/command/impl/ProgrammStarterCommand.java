/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.verbindungsraum.gsal.command.impl;

import de.bite.framework.context.IContext;
import de.verbindungsraum.gsal.command.IGSALCommand;
import de.verbindungsraum.gsal.exception.GSALCommandException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nixdorfan
 */
public class ProgrammStarterCommand implements IGSALCommand{

    private IContext context;
    private String controller_name;
    
    @Override
    public void setContext(IContext context) {
        this.context = context;
    }

    @Override
    public void setCommandString(String controller_name) {
        this.controller_name = controller_name;
        
    }

    @Override
    public void setGUIInforamtion(Object objectFromGUI) {
        //
    }

    @Override
    public void execute() throws GSALCommandException {
        try {
            Runtime.getRuntime().exec(this.controller_name);
        } catch (IOException ex) {
            ex.printStackTrace();
            this.context.getLogger().error( ex.getLocalizedMessage() );
        }
    }

    
}
