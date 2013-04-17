/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package de.bite.framework.controller.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.constants.Constants;
import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.source.Source;
import de.bite.framework.view.View;

import org.apache.log4j.Logger;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class DefaultController extends AbstractController
{

  //~--- fields ---------------------------------------------------------------

  Logger         logger = Logger.getLogger(DefaultController.class);
  public boolean isSuccessful;
  public String  actualState;

  //~--- methods --------------------------------------------------------------

  /**
   */
  @Override
  public void dispatch()
  {

    this.isSuccessful = false;

    try
    {
      this.actualState = "Start Dispatch \n";

      Source source = (Source)this.iContext.getObject("default.source", ContextType.NEW, null);
      View   view   = (View)this.iContext.getObject("default.view", ContextType.NEW, null);

      this.actualState += " generate Source and View \n ";

      logger.info(Constants.info_message + " View / Source geladen ");
      source.processInput();

      this.actualState += " process Source \n ";

      view.processOutput();

      this.actualState += " process View \n ";

      logger.info(Constants.info_message + " View / Source Verarbeitung durchgefuehrt ");

      this.actualState  += " all completed \n ";
      this.isSuccessful = true;
    }
    catch(Exception ex)
    {
      this.isSuccessful = false;
      this.actualState  += " Fehler " + ex.getLocalizedMessage() + " \n ";

      logger.error(Constants.error_message + " Controller - Dispatching fehlerhaft ", ex);
    }

  }

  /**
   *
   * @return boolean
   */
  @Override
  public boolean isSuccessful()
  {
    return this.isSuccessful;
  }

  /**
   *
   * @return String
   */
  @Override
  public String actualControllerState()
  {
    return this.actualState;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
