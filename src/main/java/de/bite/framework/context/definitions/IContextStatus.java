/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.context.definitions.IContextStatus.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

package de.bite.framework.context.definitions;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.extension.impl.ContextStatus;

//~--- interfaces -------------------------------------------------------------

/**
 *
 * @version        1.0, 2013.08.09
 * @author         bas
 */
public interface IContextStatus
{
  //~--- methods --------------------------------------------------------------

  /**
   *
   * @return ContextStatus
   */
  public ContextStatus getStatus();

  /**
   *
   * @param contextStatus ContextStatus
   */
  public void setStatus(ContextStatus contextStatus);

  /**
   *
   * @param name String
   */
  public void setActualName(String name);

  /**
   */
  public void getActualName();
}


/* ||\
 * ---------------------------------------------------------
 */
