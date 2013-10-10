/**
 *
 * Copyright (c) 2013.10.04
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.verbindungsraum.gsal.listener;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.constants.Constants;

import de.verbindungsraum.gsal.command.IGSALCommand;
import de.verbindungsraum.gsal.exception.GSALCommandException;

import org.apache.log4j.Logger;

//~--- JDK imports ------------------------------------------------------------

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class GSALActionListener implements ActionListener
{
  //~--- fields ---------------------------------------------------------------

  private IGSALCommand command;
  private Logger       logger = Logger.getLogger(GSALActionListener.class);

  //~--- constructors ---------------------------------------------------------

  /**
   *
   * @param command IGSALCommand
   */
  public GSALActionListener(IGSALCommand command)
  {
    this.command = command;
  }




  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param e ActionEvent
   */
  @Override
  public void actionPerformed(ActionEvent e)
  {
    try
    {
      this.command.execute();
    }
    catch(GSALCommandException ex)
    {
      logger.error(Constants.error_message + " " + ex.getLocalizedMessage());
    }
  }
}


/* ||\
 * ---------------------------------------------------------
 */
