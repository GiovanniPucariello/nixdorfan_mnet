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
