/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.context.extension.impl.ContextStatus.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

package de.bite.framework.context.extension.impl;

//~--- enums ------------------------------------------------------------------

/**
 */
public enum ContextStatus
{
  AKTIV(1), COPY(2), CONVERSATION_AKTIV(3), CONVERSATION_COPY(4);

  //~--- fields ---------------------------------------------------------------

  private int contextStatus;

  //~--- constructors ---------------------------------------------------------

  /**
   *
   * @param contextStatus int
   */
  private ContextStatus(int contextStatus)
  {
    this.contextStatus = contextStatus;
  }




  //~--- methods --------------------------------------------------------------

  /**
   *
   * @return int
   */
  public int getContextStatus()
  {
    return this.contextStatus;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
