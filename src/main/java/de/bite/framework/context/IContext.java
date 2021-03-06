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

  /**
   *
   * @return ILogger
   */
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

  /**
   *
   * @param filename String
   *
   * @return boolean
   */
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

  /**
   *
   * @param clazzname String
   *
   * @return Object
   */
  public Object getObject(String clazzname);

  /**
   *
   * @param objectname String
   * @param object Object
   */
  public void setObject(String objectname, Object object);

  /**
   *
   * @param clazzname String
   * @param conversationFlowState String
   *
   * @return Object
   */
  public Object getConversationObject(String clazzname, String conversationFlowState);

  /**
   *
   * @param objectname String
   * @param conversationFlowState String
   * @param object Object
   */
  public void setConversationObject(String objectname, String conversationFlowState, Object object);

  /**
   *
   * @param objectname String
   */
  public void deleteObject(String objectname);

  /**
   */
  public void clearContext();
}


/* ||\
 * ---------------------------------------------------------
 */
