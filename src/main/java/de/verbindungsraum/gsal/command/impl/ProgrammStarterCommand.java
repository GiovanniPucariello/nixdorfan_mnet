/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.verbindungsraum.gsal.command.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.IContext;

import de.verbindungsraum.gsal.command.IGSALCommand;
import de.verbindungsraum.gsal.exception.GSALCommandException;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class ProgrammStarterCommand implements IGSALCommand
{
  //~--- fields ---------------------------------------------------------------

  private IContext context;
  private String   controller_name;

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
   * @param objectFromGUI Object
   */
  @Override
  public void setGUIInforamtion(Object objectFromGUI)
  {

    //
  }

  /**
   *
   * @throws GSALCommandException
   */
  @Override
  public void execute() throws GSALCommandException
  {
    try
    {
      Runtime.getRuntime().exec(this.controller_name);
    }
    catch(IOException ex)
    {
      ex.printStackTrace();
      this.context.getLogger().error(ex.getLocalizedMessage());
    }
  }
}


/* ||\
 * ---------------------------------------------------------
 */
