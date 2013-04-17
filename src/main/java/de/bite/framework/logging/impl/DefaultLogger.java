/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.logging.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.logging.ILogger;

import org.apache.log4j.Logger;

//~--- JDK imports ------------------------------------------------------------

import java.util.Date;

import javax.swing.JTextArea;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class DefaultLogger implements ILogger
{

  //~--- fields ---------------------------------------------------------------

  private Logger    wrapperlogger = Logger.getRootLogger();
  private JTextArea jText         = null;

  //~--- methods --------------------------------------------------------------

  /**
   * 
   * @param message String
   */
  @Override
  public void debug(String message)
  {
    if(jText != null)
    {
      this.jText.append("Debug " + new Date() + " " + message + "\n");
    }

    wrapperlogger.debug(message);
  }

  /**
   * 
   * @param message String
   */
  @Override
  public void info(String message)
  {
    if(jText != null)
    {
      this.jText.append("Info " + new Date() + " " + message + "\n");
    }

    wrapperlogger.info(message);
  }

  /**
   * 
   * @param message String
   */
  @Override
  public void error(String message)
  {
    if(jText != null)
    {
      this.jText.append("Error " + new Date() + " " + message + "\n");
    }

    wrapperlogger.error(message);
  }

  /**
   * 
   * @param guiObject Object
   */
  @Override
  public void setGUIObject(Object guiObject)
  {
    this.jText = (JTextArea)guiObject;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
