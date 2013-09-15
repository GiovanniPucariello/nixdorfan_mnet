/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.context.impl.DefaultContext.java 1.0 | 2013.09.15 bas | UTF8 | tab 2
 */

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package de.bite.framework.context.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.constants.Constants;
import de.bite.framework.context.extension.impl.ContextExtension;
import de.bite.framework.context.extension.impl.ContextStatus;
import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.logging.ILogger;

import org.apache.log4j.Logger;

//~--- JDK imports ------------------------------------------------------------

import java.io.Serializable;

import java.util.Iterator;
import java.util.Set;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class DefaultContext extends AbstractContext implements Serializable
{

  //~--- static fields --------------------------------------------------------

  private static final long serialVersionUID = -3918161219521028951L;
  private static Logger     logger           = Logger.getLogger(DefaultContext.class);

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param propertyName String
   *
   * @return Object[]
   */
  @Override
  public Object[] getObjectHistory(String propertyName)
  {
    this.getLogger().info(Constants.impl_message + " getObjectHistory(String propertyName)");

    return null;
  }

  /**
   *
   * @return Object[]
   */
  @Override
  public Object[] getObjectHistory()
  {

    Set      allObjectKeys = this.contextcontainer.keySet();
    Object[] cextHistory   = null;

    this.getLogger().info("                               ");
    this.getLogger().info("                               ");
    this.getLogger().info("                               ");
    this.getLogger().info("                               ");
    this.getLogger().info("                               ");
    this.getLogger().info("S T A T U S  AKTIVER CONTEXT :: [Anzahl enthaltener Objekte] :: " + allObjectKeys.size());
    this.getLogger().info("                               | ");
    this.getLogger().info("                               | ");
    this.getLogger().info("                               | ");
    this.getLogger().info("                               | ");
    this.getLogger().info("                               | ");
    this.getLogger().info("                               | ");

    Iterator iter = allObjectKeys.iterator();

    while(iter.hasNext())
    {
      String           key  = (String)iter.next();
      ContextExtension cext = (ContextExtension)this.contextcontainer.get(key);

      this.getLogger().info("Object :: [NAME] :: " + key + " ---- " + cext);
      this.getLogger().info("                               | ");

      cextHistory = cext.getObjectHistory();

      for(int i = 0; i < cextHistory.length; i++)
      {
        this.getLogger().info("                               | ");
        this.getLogger().info("                               |----- " + cextHistory[i]);
        this.getLogger().info("                               | ");
        this.getLogger().info("                               | ");
        this.getLogger().info("                               | ");
      }
    }

    this.getLogger().info("                               | ");
    this.getLogger().info("                               |----------- EOF CONTEXT ");

    // logger.info( Constants.impl_message + " getObjectHistory()"  );
    return cextHistory;

  }

  /**
   *
   * @param clazzname String
   *
   * @return Object
   */
  @Override
  public Object getObject(String clazzname)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   *
   * @param objectname String
   * @param object Object
   */
  @Override
  public void setObject(String objectname, Object object)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   *
   * @param clazzname String
   * @param conversationFlowState String
   *
   * @return Object
   */
  @Override
  public Object getConversationObject(String clazzname, String conversationFlowState)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   *
   * @param objectname String
   * @param conversationFlowState String
   * @param object Object
   */
  @Override
  public void setConversationObject(String objectname, String conversationFlowState, Object object)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   *
   * @param objectname String
   */
  @Override
  public void deleteObject(String objectname)
  {
    throw new UnsupportedOperationException("Not supported yet.");    // To change body of generated methods, choose Tools | Templates.
  }

  /**
   */
  @Override
  public void clearContext()
  {
    throw new UnsupportedOperationException("Not supported yet.");    // To change body of generated methods, choose Tools | Templates.
  }
}


/* ||\
 * ---------------------------------------------------------
 */
