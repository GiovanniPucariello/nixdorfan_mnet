/**
 *
 * Copyright (c) 2013.06.14
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0-b147
 * 
 */

package de.bite.framework.logging;

//~--- interfaces -------------------------------------------------------------

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
