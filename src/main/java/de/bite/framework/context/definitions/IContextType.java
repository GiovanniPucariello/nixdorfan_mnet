/**
 *
 * Copyright (c) 2013.10.04
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
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
