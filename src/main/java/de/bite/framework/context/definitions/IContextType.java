/**
 *
 * Copyright (c) 2013.06.14
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0-b147
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
