/**
 *
 * Copyright (c) 2013.02.10
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

/*
* @(#)AbstractContext.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
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
import de.bite.framework.context.IContext;
import de.bite.framework.exceptions.ContextExtensionException;
import de.bite.framework.factories.Factory;
import de.bite.framework.factories.impl.DefaultFactory;
import de.bite.framework.logging.ILogger;
import de.bite.framework.logging.impl.DefaultLogger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//~--- JDK imports ------------------------------------------------------------

import java.io.FileInputStream;
import java.io.Serializable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.*;

//~--- classes ----------------------------------------------------------------

/**
 *                      AbstractContext
 *                      enthaelt Configuratoren fuer Teilbereiche oder Methoden fuer einzelne Objekte
 *                      Implementiert ueber Reflection
 *
 * @version 1.0.10
 * @author      nixdorfan ( Dr. Andreas Maximilian Kurt Wilhelm Nixdorf - Tannenberg )
 *                      bi/te - biologisch-technischer verbindungsraum -
 *                      Sept. 2011
 */

/**
 *
 * Abstrakte Klasse AbstractContext </ br>
 * alle default methoden implemetiert </ br>
 * Default-Klasse ueberschreibt nur Abstrakte Klasse
 *
 */
public abstract class AbstractContext implements IContext
{

  //~--- fields ---------------------------------------------------------------

  public HashMap< String, Object >          contextcontainer = new HashMap< String, Object >();
  public ArrayList< ContextPropertyHolder > propertyHolder   = new ArrayList< ContextPropertyHolder >();
  public Factory                            factory;
  public DefaultLogger                      logger = null;

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @return ILogger
   */
  @Override
  public ILogger getLogger()
  {
    if(logger != null)
    {

      // Singleton
      return logger;
    }
    else
    {
      logger = new DefaultLogger();

      return logger;
    }
  }

  /**
   *
   * @param initFactoryClazzName String
   *
   * @throws Exception
   */
  public void initializeContext(String initFactoryClazzName) throws Exception
  {
    if((initFactoryClazzName == null) || (initFactoryClazzName == ""))
    {
      this.setFactory(null);
    }
    else
    {
      this.setFactory(initFactoryClazzName);
    }
  }

  /**
   *
   * @param configs Properties[]
   */
  public void load(Properties[] configs)
  {

    if(configs == null)
    {
      throw new RuntimeException(" Konfiguration konnte nicht geladen werden. Ausfuehrung wird gestoppt \n");
    }
    else
    {
      for(Properties properties : configs)
      {
        ContextPropertyHolder holder = new ContextPropertyHolder();

        holder.setName("confprop_" + properties.getProperty("name"));
        holder.setProperties(properties);
        propertyHolder.add(holder);
      }

      String logging      = this.getStringValueFromProperties("logging");
      String loggingDelay = this.getStringValueFromProperties("logging_delay");

      PropertyConfigurator.configureAndWatch(logging, Integer.parseInt(loggingDelay));
      this.setObject(ContextStatus.AKTIV, propertyHolder, "configuration", null);
    }

  }

  /**
   *
   * @param filename String
   *
   * @return boolean
   */
  public boolean updateContextConfiguration(String filename)
  {

    // db check
    if(filename.substring(0, 2).equals("db"))
    {
      this.getLogger().info("no updateContextConfiguration for modified File " + filename + " -> DB-Konfig-File ");

      return true;
    }

    this.getLogger().info("Starting updateContextConfiguration for modified File " + filename);

    String                filenameWithoutPostfix = filename.substring(0, filename.indexOf("mod_properties") - 1);
    String                modulHolderName        = "";
    ContextPropertyHolder holderToRemove         = null;
    String                propertyHolderContext  = "confprop_" + filenameWithoutPostfix;
    Set< String >         keys                   = this.contextcontainer.keySet();
    ArrayList< String >   listToRemove           = new ArrayList< String >();

    for(ContextPropertyHolder holder : this.propertyHolder)
    {
      modulHolderName = holder.getName().replaceAll("confprop_", "");

      if(modulHolderName.equals(filenameWithoutPostfix))
      {
        holderToRemove = holder;

        for(String key : keys)
        {
          this.getLogger().info(" checked key == " + key);

          if(holderToRemove.containsKey(key))
          {
            listToRemove.add(key);
            this.getLogger().info(" key checked for removing == " + key);
          }
        }
      }
    }

    this.propertyHolder.remove(holderToRemove);

    try
    {
      ContextPropertyHolder holderNew = new ContextPropertyHolder();

      holderNew.setName("confprop_" + filenameWithoutPostfix);

      Properties reload = new Properties();

      reload.load(new FileInputStream((String)this.getObject("basepath", ContextType.USED, null) + "/" + filenameWithoutPostfix + ".mod_properties"));
      holderNew.setProperties(reload);
      this.propertyHolder.add(holderNew);

      for(String keyToRemove : listToRemove)
      {
        this.getLogger().info(keyToRemove);
        this.contextcontainer.remove(keyToRemove);
      }
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      this.getLogger().error("updateContextConfiguration for " + filename);

      return false;
    }

    return true;
  }

  /**
   *
   * @param objectName String
   * @param contextType ContextType
   * @param contextStatusFlowName String
   *
   * @return Object
   */
  public Object getObject(String objectName, ContextType contextType, String contextStatusFlowName)
  {

    if(contextType == ContextType.NEW)
    {

      if(this.contextcontainer.containsKey(objectName))
      {
        contextType = ContextType.USED;

        ContextExtension extension = (ContextExtension)this.contextcontainer.get(objectName);

        if(extension == null)
        {
          this.getLogger().debug(Constants.warning_message + " getObject -- Extension  N I C H T  gefunden fuer " + objectName);

          return null;
        }

        Object obj = null;

        if(contextStatusFlowName != null)
        {
          try
          {
            obj = extension.get(contextStatusFlowName);
          }
          catch(Exception ex)
          {
            obj = null;

            this.getLogger().error(Constants.error_message + " kein Object fuer ContextFlow == " + contextStatusFlowName);
          }
        }
        else
        {
          obj = extension.get();
        }

        if(obj == null)
        {
          this.getLogger().info(Constants.warning_message + " getObject -- Object in Extension  N I C H T  gefunden fuer " + objectName);

          return null;
        }

        return obj;
      }
      else
      {
        Object obj = this.factory.getObject(this.getClazzNameFromPropertyHolder(objectName));

        this.getLogger().info(Constants.info_message + " [getObject] -- Object wird generiert fuer " + objectName);

        try
        {
          Method method = obj.getClass().getMethod("setContext", IContext.class);

          method.invoke(obj, this);
        }
        catch(NoSuchMethodException ex)
        {

          // LOgging wird heruntergebracht
          // this.getLogger().info(Constants.warning_message + " Reflection DI nicht erfolgreich fuer  " + objectName + " ... Methode nicht vorhanden. Fortfahren ohne DI des Contextes ");
          // ex.printStackTrace();
        }
        catch(Exception ex)
        {
          this.getLogger().info(Constants.warning_message + " Reflection DI nicht erfolgreich fuer  " + objectName + " ... allgemeiner Fehler. Fortfahren ohne DI des Contextes ");

          // ex.printStackTrace();
        }

        setObject(ContextStatus.AKTIV, obj, objectName, null);

        // this.getLogger().info(Constants.info_message + " [getObject] -- Object wird in Context gespeichert [BOUND] fuer "+ objectName);
        return obj;
      }

    }
    else if(contextType == ContextType.USED)
    {
      ContextExtension extension = (ContextExtension)this.contextcontainer.get(objectName);

      if(extension == null)
      {
        this.getLogger().info(Constants.warning_message + " getObject -- Extension  N I C H T  gefunden fuer " + objectName);

        return null;
      }

      Object obj = null;

      if(contextStatusFlowName != null)
      {
        try
        {
          obj = extension.get(contextStatusFlowName);
        }
        catch(Exception ex)
        {
          obj = null;

          this.getLogger().error(Constants.error_message + " kein Object fuer ContextFlow == " + contextStatusFlowName);
        }
      }
      else
      {
        obj = extension.get();
      }

      if(obj == null)
      {
        this.getLogger().info(Constants.warning_message + " getObject -- Object in Extension  N I C H T  gefunden fuer " + objectName);

        return null;
      }

      return obj;
    }
    else
    {
      this.getLogger().info(Constants.warning_message + " getObject -- Fehlerhafter Context-Type fuer " + objectName);

      return null;
    }

  }

  /**
   *
   * @param objectName String
   *
   * @return Object
   */
  @Override
  public Object getUnboundObject(String objectName)
  {

    Object obj = this.factory.getObject(this.getClazzNameFromPropertyHolder(objectName));

    try
    {
      Method method = obj.getClass().getMethod("setContext", IContext.class);

      method.invoke(obj, this);
    }
    catch(NoSuchMethodException ex)
    {

      // this.getLogger().info(Constants.warning_message + "[getUnboundObject] Reflection DI nicht erfolgreich fuer  " + objectName + " ... Methode nicht vorhanden. Fortfahren ohne DI des Contextes ");
      // ex.printStackTrace();
    }
    catch(Exception ex)
    {
      this.getLogger().info(Constants.warning_message + "[getUnboundObject] Reflection DI nicht erfolgreich fuer  " + objectName + "  ... allgemeiner Fehler. Fortfahren ohne DI des Contextes ");
      ex.printStackTrace();
    }

    // this.getLogger().info(Constants.info_message + " [getObject] -- Object wird NICHT in Context gespeichert [UNBOUND] fuer "+ objectName + ": WENN SPEICHERUNG NOTWENDIG DANN MNAUELL SETZEN UEBER setObject()!");
    return obj;

  }

  /**
   *
   * @param contextStatus ContextStatus
   * @param member Object
   * @param objectName String
   * @param contextStatusFlowName String
   *
   * @return String
   */
  public String setObject(ContextStatus contextStatus, Object member, String objectName, String contextStatusFlowName)
  {

    if(contextStatus == null)
    {
      contextStatus = ContextStatus.AKTIV;
    }

    try
    {
      if(contextStatusFlowName != null)
      {
        if(this.contextcontainer.get(objectName) instanceof ContextExtension)
        {    // Object bereits in Context angelegt
          ContextExtension extension = (ContextExtension)this.contextcontainer.get(objectName);

          extension.set(member, contextStatus, contextStatusFlowName);
        }
        else
        {    // Object noch nicht in Context abgelegt
          ContextExtension extension = new ContextExtension();

          extension.setContext(this);
          extension.setName(objectName);
          extension.set(member, contextStatus, contextStatusFlowName);
          this.contextcontainer.put(objectName, extension);
        }
      }
      else
      {
        if((this.getObject(objectName, ContextType.USED, null) instanceof ContextExtension) && (contextStatusFlowName == null))
        {    // Object bereits in Context angelegt
          ContextExtension extension = (ContextExtension)this.getObject(objectName, ContextType.USED, null);

          extension.set(member, contextStatus, contextStatusFlowName);
        }
        else
        {    // Object noch nicht in Context abgelegt
          ContextExtension extension = new ContextExtension();

          extension.setContext(this);
          extension.setName(objectName);
          extension.set(member, contextStatus, contextStatusFlowName);
          this.contextcontainer.put(objectName, extension);
        }
      }

      return "ok";
    }
    catch(ContextExtensionException ex)
    {
      ex.printStackTrace();

      return null;
    }

  }

  /**
   *
   * @return Factory
   *
   * @throws Exception
   */
  public Factory getFactory() throws Exception
  {
    if(this.factory == null)
    {
      throw new RuntimeException("no factory for AbstractContext found");
    }

    return this.factory;
  }

  /**
   *
   * @param clazzname String
   *
   * @throws Exception
   *
   */
  private void setFactory(String clazzname) throws Exception
  {
    if(clazzname == null)
    {
      this.factory = new DefaultFactory();
    }
    else
    {
      try
      {
        Class< ? > factoryClazz = Class.forName(clazzname);

        this.factory = (Factory)factoryClazz.newInstance();
      }
      catch(Exception ex)
      {
        throw new RuntimeException(ex);
      }
    }
  }

  /**
   *
   * @param inContext Object
   * @param toPutIntoContext Object
   *
   * @return  TRUE if the tow objects have the same reference, then they were equal
   *                  FALSE if the tow objects have not the same reference
   *
   */
  protected boolean isExistingContextObjectEqual(Object inContext, Object toPutIntoContext)
  {
    if(inContext.equals(toPutIntoContext))
    {
      this.getLogger().info(Constants.info_message + "[isExistingContextObjectEqual] Referenzvergleich POSITIV. Vorhandenes Objekt " + inContext + " und zu sopeicherndes Object " + toPutIntoContext +
                            " identisch ");

      return true;
    }
    else
    {
      this.getLogger().info(Constants.info_message + "[isExistingContextObjectEqual] Referenzvergleich NEGATIV. Vorhandenes Objekt " + inContext + " und zu speicherndes Object " + toPutIntoContext +
                            " nicht identisch ");

      return false;
    }
  }

  /**
   *  Helper-Methodes for internal use
   *
   *
   * @param propertiesKey String
   *
   * @return String
   */
  private String getClazzNameFromPropertyHolder(String propertiesKey)
  {

    if(this.propertyHolder.isEmpty())
    {
      throw new RuntimeException(Constants.error_message + " K E I N E  K O N F I G U R A T I O N  geladen!");
    }

    Iterator< ContextPropertyHolder > propertiesEnum = this.propertyHolder.iterator();

    while(propertiesEnum.hasNext())
    {
      ContextPropertyHolder holder = propertiesEnum.next();

      if(holder.containsKey(propertiesKey))
      {
        return holder.getProperties(propertiesKey);
      }
    }

    this.getLogger().info(Constants.warning_message + " Properties-Key fuer Laden der Klasse nicht gefunden == " + propertiesKey);

    return null;

  }

  /**
   * public method for getting properties-values
   *
   * @param propertiesKey String
   *
   * @return String
   */
  public String getStringValueFromProperties(String propertiesKey)
  {
    String delegateReturn = getClazzNameFromPropertyHolder(propertiesKey);

    this.getLogger().info(delegateReturn);

    return delegateReturn;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
