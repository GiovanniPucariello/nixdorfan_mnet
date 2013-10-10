/**
 *
 * Copyright (c) 2013.10.04
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.logging;

//~--- interfaces -------------------------------------------------------------

/**
 *
 * @version        1.0, 2013.08.09
 * @author         bas
 */
public interface ILogger
{
  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param guiObject Object
   */
  public void setGUIObject(Object guiObject);

  /**
   *
   * @param message String
   */
  public void debug(String message);

  /**
   *
   * @param message String
   */
  public void info(String message);

  /**
   *
   * @param message String
   */
  public void error(String message);
}


/* ||\
 * ---------------------------------------------------------
 */
