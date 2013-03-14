/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
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
