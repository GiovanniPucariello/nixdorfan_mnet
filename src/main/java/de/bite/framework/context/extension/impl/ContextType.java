/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.context.extension.impl.ContextType.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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
