/**
 *
 * Copyright (c) 2013.10.04
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

/*
* @(#)AbstractModel.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package de.bite.framework.model.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.model.Model;

//~--- JDK imports ------------------------------------------------------------

import java.io.Serializable;

import java.util.HashMap;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public abstract class AbstractModel implements Model, Serializable
{

  //~--- fields ---------------------------------------------------------------

  public HashMap< String, Object > data;
  public String                    name;

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param name String
   */
  @Override
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   *
   * @param data HashMap<String,Object>
   */
  @Override
  public void setData(HashMap< String, Object > data)
  {
    this.data = data;
  }

  /**
   *
   * @param name String
   *
   * @return Object
   */
  @Override
  public Object getSingleData(String name)
  {
    if(this.data.containsKey(name) == true)
    {
      return this.data.get(name);
    }
    else
    {
      return "not found";
    }
  }

  /**
   *
   * @return HashMap<String,String>
   */
  @Override
  public abstract HashMap< String, String > getStatesAndValues();

  /**
   *
   * @param name String
   * @param value String
   */
  @Override
  public abstract void setProcessingState(String name, String value);

  /**
   *
   * @return String
   */
  @Override
  public abstract String getProcessingStateName();

  /**
   *
   * @return String
   */
  @Override
  public abstract String getProcessingStateValue();
}


/* ||\
 * ---------------------------------------------------------
 */
