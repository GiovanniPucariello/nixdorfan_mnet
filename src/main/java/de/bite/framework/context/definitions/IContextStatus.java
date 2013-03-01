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

import de.bite.framework.context.extension.impl.ContextStatus;

//~--- interfaces -------------------------------------------------------------

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
