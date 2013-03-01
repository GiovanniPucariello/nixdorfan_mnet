/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bite.framework.logging.impl;

import de.bite.framework.logging.ILogger;
import java.util.Date;
import javax.swing.JTextArea;
import org.apache.log4j.Logger;

/**
 *
 * @author nixdorfan
 */
public class DefaultLogger implements ILogger {

    private Logger wrapperlogger  = Logger.getRootLogger();
    private JTextArea jText = null;
    
    @Override
    public void debug(String message) {
        if (jText != null){
            this.jText.append("Debug " + new Date()+ " " +  message + "\n");
        }
        wrapperlogger.debug(message);
    }

    @Override
    public void info(String message) {
        if (jText != null){
            this.jText.append("Info " + new Date()+ " " +  message + "\n");
        }
        wrapperlogger.info(message);
    }

    @Override
    public void error(String message) {
        
        if (jText != null){
            this.jText.append("Error " + new Date()+ " " +  message + "\n");
        }
        wrapperlogger.error(message);
    }

    @Override
    public void setGUIObject(Object guiObject) {
        this.jText = (JTextArea)guiObject;
    }
    
}
