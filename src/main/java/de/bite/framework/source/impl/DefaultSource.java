/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.source.impl.DefaultSource.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

/*
* @(#)DefaultSource.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package de.bite.framework.source.impl;

//~--- non-JDK imports --------------------------------------------------------

import org.apache.log4j.Logger;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class DefaultSource extends AbstractSource
{
  //~--- fields ---------------------------------------------------------------

  Logger logger = Logger.getLogger(DefaultSource.class);

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @return boolean
   */
  @Override
  public boolean processInput()
  {
    logger.info("DefaultSource processInput arbeitet. Framework aktiv");

    // TODO: nach Version 1.0.0 csv-Einlesen ermoeglichen
    return false;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
