/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package de.bite.framework.source.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.IContext;
import de.bite.framework.source.Source;

//~--- JDK imports ------------------------------------------------------------

import java.io.Serializable;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public abstract class AbstractSource implements Source, Serializable
{
  //~--- fields ---------------------------------------------------------------

  public IContext iContext;

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param iContext Context
   */
  @Override
  public void setContext(IContext iContext)
  {
    this.iContext = iContext;
  }

  /**
   *
   * @return boolean
   */
  @Override
  public abstract boolean processInput();
}


/* ||\
 * ---------------------------------------------------------
 */
