/**
 *
 * Copyright (c) 2012.03.08
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_01-b08
 * 
 */

/*
* @(#)Context.java   11/12/16
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package de.bite.framework.context;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.extension.impl.ContextStatus;
import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.logging.ILogger;

//~--- JDK imports ------------------------------------------------------------

import java.util.Properties;

//~--- interfaces -------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public interface IContext
{

  //~--- methods --------------------------------------------------------------


  public ILogger getLogger();

  /**
   * @param factoryClazzName String
   *
   * @throws Exception
   */
  public void initializeContext(String factoryClazzName) throws Exception;

  /**
   *
   * @param configs Properties[]
   */
  public void load(Properties[] configs);

  
  public boolean updateContextConfiguration(String filename);
  /**
   *
   * 
   * @param objectName String
   * @param contextType ContextType
   * @param contextStatusFlowName String
   *
   * @return Object
   */
  public Object getObject(String objectName, ContextType contextType, String contextStatusFlowName);
  
   /**
   *
   * 
   * @param objectName String
   * @return Object
   */
  public Object getUnboundObject(String objectName);

  /**
   *
   * 
   * @param contextStatus ContextStatus
   * @param member Object
   * @param objectName String
   * @param contextStatusFlowName String
   *
   * @return String
   */
  public String setObject(ContextStatus contextStatus, Object member, String objectName, String contextStatusFlowName);

  /**
   * 
   * @param propertyName String
   * @return object-history of the given object
   */
  public Object[] getObjectHistory(String propertyName);

  /**
   *
   * @return all object-histories within this context
   */
  public Object[] getObjectHistory();

  /**
   * 
   * @param propertiesKey String
   * @return String-Value related to property
   */
  public String getStringValueFromProperties(String propertiesKey);
}


/* ||\
 * ---------------------------------------------------------
 */
