/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.model.Model.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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
