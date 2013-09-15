/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.logging.impl.DefaultLogger.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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
