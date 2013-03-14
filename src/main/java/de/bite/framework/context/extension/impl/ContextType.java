/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.context.extension.impl;

//~--- enums ------------------------------------------------------------------

/**
 */
public enum ContextType
{
  NEW(1), USED(2);

  //~--- fields ---------------------------------------------------------------

  private int contextType;

  //~--- constructors ---------------------------------------------------------

  /**
   *
   *
   * @param contextType int
   */
  private ContextType(int contextType)
  {
    this.contextType = contextType;
  }




  //~--- methods --------------------------------------------------------------

  /**
   *
   * @return int
   */
  public int getContextStatus()
  {
    return this.contextType;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
