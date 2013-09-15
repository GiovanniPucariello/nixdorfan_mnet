/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.verbindungsraum.gsal.listener.GSALActionListener.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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
