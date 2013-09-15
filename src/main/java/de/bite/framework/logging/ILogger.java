/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.logging.ILogger.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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
