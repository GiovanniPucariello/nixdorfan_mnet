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

import de.bite.framework.context.extension.impl.ContextStatus;

//~--- interfaces -------------------------------------------------------------

/**
 *
 * @version        1.0, 2013.08.09
 * @author         bas
 */
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
