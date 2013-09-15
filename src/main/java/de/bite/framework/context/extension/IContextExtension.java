/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.context.extension.IContextExtension.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

package de.bite.framework.context.extension;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.extension.impl.ContextStatus;
import de.bite.framework.context.IContext;
import de.bite.framework.exceptions.ContextExtensionException;

//~--- interfaces -------------------------------------------------------------

/**
 * @author      nixdorfan, 01.12.2011
 */
public interface IContextExtension
{
  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param context IContext
   */
  public void setContext(IContext context);

  /**
   *
   * @param name String
   * @throws      ContextExtensionException if name is already set
   *
   */
  public void setName(String name) throws ContextExtensionException;

  /**
   * @return      object name
   */
  public String getName();

  /**
   * @param       object, ContextStatus, String contextFlow
   * @param status ContextStatus
   * @param conversationState String
   * @throws      ContextExtensionException if name is not set
   */
  public void set(Object object, ContextStatus status, String conversationState) throws ContextExtensionException;

  /**
   * @return      actual stored active object
   */
  public Object get();

  /**
   *
   * @param conversationState String
   *  @throws   ContextExtensionException if this conversationState is not found or there is no conversationState in this ContextExtension
   *  @return   Object; the state of the stored object regarding to the converstion at this time
   *
   */
  public Object get(String conversationState) throws ContextExtensionException;

  /**
   * @return      history of stored objects. Internal stored objects will be cloned
   */
  public Object[] getObjectHistory();

  /**
   *
   * @param object Object
   * @param status ContextStatus
   * @param contexFlow String
   * @return      true if object successfully stored, false if not
   *
   * @throws ContextExtensionException
   */
  public boolean process(Object object, ContextStatus status, String contexFlow) throws ContextExtensionException;
}


/* ||\
 * ---------------------------------------------------------
 */
