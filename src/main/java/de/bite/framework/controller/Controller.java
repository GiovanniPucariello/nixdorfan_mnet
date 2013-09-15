/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.controller.Controller.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

/*
* @(#)Controller.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package de.bite.framework.controller;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.IContext;

//~--- interfaces -------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public interface Controller
{
  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param iContext Context
   */
  public void setContext(IContext iContext);

  /**
   */
  public void dispatch();

  /**
   *
   * @return boolean
   */
  public boolean isSuccessful();

  /**
   *
   * @return String
   */
  public String actualControllerState();
}


/* ||\
 * ---------------------------------------------------------
 */
