/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.controller.impl.AbstractController.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package de.bite.framework.controller.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.constants.Constants;
import de.bite.framework.context.IContext;
import de.bite.framework.controller.Controller;

import org.apache.log4j.Logger;

//~--- JDK imports ------------------------------------------------------------

import java.io.Serializable;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public abstract class AbstractController implements Controller, Serializable
{
  //~--- fields ---------------------------------------------------------------

  public Logger   logger = Logger.getLogger(AbstractController.class);
  public IContext iContext;

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param iContext Context
   */
  @Override
  public void setContext(IContext iContext)
  {
    this.iContext = iContext;

    logger.info(Constants.info_message + " Context gesetzt :: " + iContext.toString());
  }

  /**
   */
  @Override
  public abstract void dispatch();

  /**
   *
   * @return boolean
   */
  public abstract boolean isSuccessful();

  /**
   *
   * @return String
   */
  public abstract String actualControllerState();
}


/* ||\
 * ---------------------------------------------------------
 */
