/**
 *
 * Copyright (c) 2012.03.08
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_01-b08
 * 
 */

package de.bite.framework.context.definitions;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.extension.impl.ContextType;

//~--- interfaces -------------------------------------------------------------

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
