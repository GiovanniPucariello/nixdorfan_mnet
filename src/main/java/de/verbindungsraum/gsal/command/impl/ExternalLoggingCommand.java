/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.verbindungsraum.gsal.command.impl;

import de.bite.framework.context.IContext;
import de.bite.framework.constants.Constants;

import de.verbindungsraum.gsal.command.IGSALCommand;
import de.verbindungsraum.gsal.exception.GSALCommandException;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author nixdorfan
 */
public class ExternalLoggingCommand implements IGSALCommand {

    private IContext context;
    private String controller_name;
    private JTextArea jTextArea;
   
    @Override
    public void setContext(IContext context) {
        this.context = context;
    }

    @Override
    public void setCommandString(String controller_name) {
        this.controller_name = controller_name;
    }

    @Override
    public void setGUIInforamtion(Object fromGUI) {
        this.jTextArea = (JTextArea)fromGUI;
    }
    
    @Override
    public void execute() throws GSALCommandException {
        String loggingFilePath = this.controller_name;
        Path file = FileSystems.getDefault().getPath(loggingFilePath);
        try {
            InputStream in = Files.newInputStream(file);
            BufferedReader reader =
                    new BufferedReader(
                    new InputStreamReader(in));
            String line = null;
            StringBuffer stringB = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                stringB.append(line + "\n");
            }
            this.jTextArea.setText(stringB.toString());
            int i = jTextArea.getText().length();
            jTextArea.setCaretPosition(i);
        } catch (Exception x) {
            System.err.println(x);
            this.jTextArea.setText(Constants.error_message + "  " + x.getLocalizedMessage());
        }  
    }

}
