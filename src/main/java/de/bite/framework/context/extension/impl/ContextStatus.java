/**
 *
 * Copyright (c) 2012.03.08
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_01-b08
 * 
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