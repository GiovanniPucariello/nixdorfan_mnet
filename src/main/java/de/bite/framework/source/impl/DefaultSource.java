/**
 *
 * Copyright (c) 2013.10.04
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
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
