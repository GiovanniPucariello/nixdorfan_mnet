/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.view.impl.DefaultView.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

/*
* @(#)DefaultView.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package de.bite.framework.view.impl;

//~--- non-JDK imports --------------------------------------------------------

import org.apache.log4j.Logger;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class DefaultView extends AbstractView
{
  //~--- fields ---------------------------------------------------------------

  Logger logger = Logger.getLogger(DefaultView.class);

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @return boolean
   */
  @Override
  public boolean processOutput()
  {
    logger.info("DefaultView processOutput arbeitet. Framework aktiv");

    // TODO: nach Version 1.0.0 schreiben in Datenbank ermoeglichen
    return false;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
