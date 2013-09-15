/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.view.impl.AbstractView.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

/*
* @(#)AbstractView.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package de.bite.framework.view.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.IContext;
import de.bite.framework.view.View;

//~--- JDK imports ------------------------------------------------------------

import java.io.Serializable;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public abstract class AbstractView implements View, Serializable
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
  public abstract boolean processOutput();
}


/* ||\
 * ---------------------------------------------------------
 */
