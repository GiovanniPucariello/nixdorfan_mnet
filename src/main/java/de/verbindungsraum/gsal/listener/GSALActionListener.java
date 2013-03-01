/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.verbindungsraum.gsal.listener;

import de.bite.framework.constants.Constants;
import de.verbindungsraum.gsal.command.IGSALCommand;
import de.verbindungsraum.gsal.exception.GSALCommandException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.log4j.Logger;

/**
 *
 * @author nixdorfan
 */
public class GSALActionListener implements ActionListener {

    private IGSALCommand command;
    private Logger logger = Logger.getLogger(GSALActionListener.class);
    
    public GSALActionListener(IGSALCommand command){
        this.command = command;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)  {
        try{
            this.command.execute();
        } catch(GSALCommandException ex){
            logger.error(Constants.error_message + " " + ex.getLocalizedMessage() );
        }
    }
    
}
