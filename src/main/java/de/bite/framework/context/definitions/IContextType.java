/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.context.definitions.IContextType.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

package de.bite.framework.context.definitions;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.extension.impl.ContextType;

//~--- interfaces -------------------------------------------------------------

/**
 *
 * @version        1.0, 2013.08.09
 * @author         bas
 */
public interface IContextType
{
  //~--- methods --------------------------------------------------------------

  /**
   *
   * @return ContextType
   */
  public ContextType getType();

  /**
   *
   * @param contextType ContextType
   */
  public void setType(ContextType contextType);
}


/* ||\
 * ---------------------------------------------------------
 */
