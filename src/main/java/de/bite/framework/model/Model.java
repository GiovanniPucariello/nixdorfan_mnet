/**
 *
 * Copyright (c) 2013.06.14
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0-b147
 * 
 */

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package de.bite.framework.model;

//~--- JDK imports ------------------------------------------------------------

import java.util.HashMap;

//~--- interfaces -------------------------------------------------------------

/**
 * 21.04.2011
 * @author nixdorfan
 */
public interface Model
{
  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param name String
   */
  public void setName(String name);

  /**
   *
   * @param data HashMap<String,Object>
   */
  public void setData(HashMap< String, Object > data);

  /**
   *
   * @return HashMap<String,Object>
   */
  public HashMap< String, Object > getAllData();

  /**
   *
   * @param name String
   *
   * @return Object
   */
  public Object getSingleData(String name);

  /**
   *
   * @param name String
   * @param value String
   */
  public void setProcessingState(String name, String value);

  /**
   *
   * @return String
   */
  public String getProcessingStateName();

  /**
   *
   * @return String
   */
  public String getProcessingStateValue();

  /**
   *
   * @return HashMap<String,String>
   */
  public HashMap< String, String > getStatesAndValues();
}


/* ||\
 * ---------------------------------------------------------
 */
