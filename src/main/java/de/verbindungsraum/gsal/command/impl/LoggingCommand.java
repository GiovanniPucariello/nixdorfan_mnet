/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.verbindungsraum.gsal.command.impl.LoggingCommand.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

package de.verbindungsraum.gsal.command.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.constants.Constants;
import de.bite.framework.context.IContext;

import de.verbindungsraum.gsal.command.IGSALCommand;
import de.verbindungsraum.gsal.exception.GSALCommandException;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.swing.JFrame;
import javax.swing.JTextArea;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class LoggingCommand implements IGSALCommand
{

  //~--- fields ---------------------------------------------------------------

  private IContext  context;
  private String    controller_name;
  private JTextArea jTextArea;

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param context IContext
   */
  @Override
  public void setContext(IContext context)
  {
    this.context = context;
  }

  /**
   *
   * @param controller_name String
   */
  @Override
  public void setCommandString(String controller_name)
  {
    this.controller_name = controller_name;
  }

  /**
   *
   * @throws GSALCommandException
   */
  @Override
  public void execute() throws GSALCommandException
  {

    String loggingFilePath = this.context.getStringValueFromProperties("loggingFilePath");
    String loggingFile     = this.context.getStringValueFromProperties("loggingFile");
    Path   file            = FileSystems.getDefault().getPath(loggingFilePath, loggingFile);

    try
    {
      InputStream    in      = Files.newInputStream(file);
      BufferedReader reader  = new BufferedReader(new InputStreamReader(in));
      String         line    = null;
      StringBuffer   stringB = new StringBuffer();

      while((line = reader.readLine()) != null)
      {
        stringB.append(line + "\n");
      }

      this.jTextArea.setText(stringB.toString());

      int i = jTextArea.getText().length();

      jTextArea.setCaretPosition(i);
    }
    catch(Exception x)
    {
      System.err.println(x);
      this.jTextArea.setText(Constants.error_message + "  " + x.getLocalizedMessage());
    }

  }

  /**
   *
   * @param fromGUI Object
   */
  @Override
  public void setGUIInforamtion(Object fromGUI)
  {
    this.jTextArea = (JTextArea)fromGUI;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
