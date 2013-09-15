/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.verbindungsraum.gsal.command.IGSALCommand.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

package de.verbindungsraum.gsal.command;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.IContext;

import de.verbindungsraum.gsal.exception.GSALCommandException;

//~--- JDK imports ------------------------------------------------------------

import javax.swing.JFrame;

//~--- interfaces -------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public interface IGSALCommand
{
  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param context IContext
   */
  public void setContext(IContext context);

  /**
   *
   * @param controller_name String
   */
  public void setCommandString(String controller_name);

  /**
   *
   * @param objectFromGUI Object
   */
  public void setGUIInforamtion(Object objectFromGUI);

  /**
   *
   * @throws GSALCommandException
   */
  public void execute() throws GSALCommandException;
}


/* ||\
 * ---------------------------------------------------------
 */
