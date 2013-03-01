/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.verbindungsraum.gsal.command.impl;

import de.bite.framework.context.IContext;
import de.bite.framework.controller.Controller;
import de.bite.framework.constants.Constants;
import de.bite.framework.context.extension.impl.ContextType;
import de.verbindungsraum.gsal.command.IGSALCommand;
import de.verbindungsraum.gsal.exception.GSALCommandException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author nixdorfan
 */
public class GSALCommand implements IGSALCommand {

    private IContext context;
    private String controller_name;
    
    
    @Override
    public void execute() throws GSALCommandException {
       
        try{
            
           // pruefen ob Programm wirklich gestartet werden soll
           int eingabe = JOptionPane.showConfirmDialog(null,
                                                            "Soll das Modul " + this.controller_name + " gestartet werden?",
                                                            "Starte Modul",
                                                            JOptionPane.YES_NO_CANCEL_OPTION);
           
           if (eingabe == JOptionPane.NO_OPTION){
               this.context.getLogger().info("ActionCommand Start fuer Controller Modul " + this.controller_name +" nicht ausgefuehrt ... ");
               return ;
           }

   
            SwingWorker worker = new SwingWorker<String, String >() {
           
            
            public String doInBackground() {
                Controller controll = (Controller)context.getObject( controller_name, ContextType.NEW,null);
                controll.dispatch();
                return controll.actualControllerState();
            }

            @Override
            public void done() {
                try {
                    String modulDone = get();
                } catch (InterruptedException ignore) {
                } catch (java.util.concurrent.ExecutionException e) {
                    String why = null;
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        why = cause.getMessage();
                        cause.printStackTrace();
                    } else {
                        cause.printStackTrace();
                        why = e.getMessage();
                    }
                    context.getLogger().error(Constants.error_message+" Error executing Command : " + why);
                }
            }
 
        };

        worker.execute();
            
            
            
            
            
            
        } catch (Exception ex){
            ex.printStackTrace();
            throw new GSALCommandException(Constants.error_message + " " + ex.getLocalizedMessage());
            
        }
    }

    @Override
    public void setContext(IContext context) {
        this.context = context;
    }

    @Override
    public void setCommandString(String controller_name) {
        this.controller_name = controller_name + ".controller";
    }

    @Override
    public void setGUIInforamtion(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
