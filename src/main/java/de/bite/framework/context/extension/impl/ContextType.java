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
