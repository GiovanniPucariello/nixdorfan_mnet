/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.bootstrap.impl.Bootstrap.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

/*
* @(#)Bootstrap.java   11/12/16
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package de.bite.framework.bootstrap.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.bootstrap.IPropertyLoader;
import de.bite.framework.context.extension.impl.ContextStatus;
import de.bite.framework.context.IContext;
import de.bite.framework.context.impl.DefaultContext;
import de.bite.framework.context.impl.SimpleUsageContext;
import de.bite.framework.factories.Factory;
import de.bite.framework.factories.impl.DefaultFactory;

//~--- JDK imports ------------------------------------------------------------

import java.util.HashMap;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class Bootstrap
{

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param consoleValues String
   *
   * @return Context
   */
  public static IContext startContext(String consoleValues)
  {

    try
    {

      // System.out.println("Konsolenwerte : " + consoleValues);
      //
      String[]                  values            = consoleValues.split("@@@");
      HashMap< String, String > consoleHashValues = new HashMap< String, String >();

      for(int i = 0; i < values.length; i++)
      {
        if(values[i].indexOf("=") != -1)
        {
          String[] singleVals = values[i].split("=");

          consoleHashValues.put(singleVals[0], singleVals[1]);
        }
      }

      /** B o o t s t r a p Context */
      IContext       iContext = new SimpleUsageContext();
      DefaultFactory dfactory = new DefaultFactory();

      // Factory wenn vorhanden, ansonsten waehle Default
      iContext.initializeContext(null);

      IPropertyLoader loader      = null;
      String          startValues = "";

      if(consoleHashValues.containsKey("propertyloader"))
      {
        loader = (IPropertyLoader)dfactory.getObject(consoleHashValues.get("propertyloader"));

        String resource = consoleHashValues.get("resource");

        if(resource == null)
        {
          throw new RuntimeException("keine resource [resource=db || resource=path] angegeben");
        }
        else
        {
          if(resource.equalsIgnoreCase("path"))
          {
            startValues = consoleHashValues.get("path");
          }
          else if(resource.equalsIgnoreCase("db"))
          {
            startValues = consoleHashValues.get("dbkonfig") + "@@@" + consoleHashValues.get("dbreflection");
          }
          else
          {
            throw new RuntimeException("Konsolenkonfiguration unvollstaendig");
          }
        }
      }
      else
      {
        throw new RuntimeException("kein Propertyloader [propertyloader=de.bite.framework.bootstrap.impl.PropertyLoader || propertyloader=de.bite.framework.bootstrap.impl.PropertyLoaderDB] angegeben");
      }

      iContext.load(loader.loadProperties(startValues));

      // setze basepath in Context
      // basepath enthaelt alle configfiles
      String basepath = consoleHashValues.get("path");

      iContext.setObject(ContextStatus.AKTIV, basepath, "basepath", null);

      // Lade Properties
      // return Context
      return iContext;
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      throw new RuntimeException("Context konnte nicht geladen werden. Start Applikation wird gestoppt \n", ex);
    }

  }

  /**
   * Define another context instead of DefaultContext. IMplement Interface IContext.
   *
   * @param consoleValues String
   * @param factory Factory
   * @param context IContext
   *
   * @return IContext
   */
  public static IContext startContext(String consoleValues, Factory factory, IContext context)
  {

    try
    {

      // System.out.println("Konsolenwerte : " + consoleValues);
      //
      String[]                  values            = consoleValues.split("@@@");
      HashMap< String, String > consoleHashValues = new HashMap< String, String >();

      for(int i = 0; i < values.length; i++)
      {
        if(values[i].indexOf("=") != -1)
        {
          String[] singleVals = values[i].split("=");

          consoleHashValues.put(singleVals[0], singleVals[1]);
        }
      }

      // Factory wenn vorhanden, ansonsten waehle Default
      context.initializeContext(null);

      IPropertyLoader loader      = null;
      String          startValues = "";

      if(consoleHashValues.containsKey("propertyloader"))
      {
        loader = (IPropertyLoader)factory.getObject(consoleHashValues.get("propertyloader"));

        String resource = consoleHashValues.get("resource");

        if(resource == null)
        {
          throw new RuntimeException("keine resource [resource=db || resource=path] angegeben");
        }
        else
        {
          if(resource.equalsIgnoreCase("path"))
          {
            startValues = consoleHashValues.get("path");
          }
          else if(resource.equalsIgnoreCase("db"))
          {
            startValues = consoleHashValues.get("dbkonfig") + "@@@" + consoleHashValues.get("dbreflection");
          }
          else
          {
            throw new RuntimeException("Konsolenkonfiguration unvollstaendig");
          }
        }
      }
      else
      {
        throw new RuntimeException("kein Propertyloader [propertyloader=de.bite.framework.bootstrap.impl.PropertyLoader || propertyloader=de.bite.framework.bootstrap.impl.PropertyLoaderDB] angegeben");
      }

      context.load(loader.loadProperties(startValues));

      // setze basepath in Context
      // basepath enthaelt alle configfiles
      String basepath = consoleHashValues.get("path");

      context.setObject(ContextStatus.AKTIV, basepath, "basepath", null);

      // Lade Properties
      // return Context
      return context;
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      throw new RuntimeException("Context konnte nicht geladen werden. Start Applikation wird gestoppt \n", ex);
    }

  }
}


/* ||\
 * ---------------------------------------------------------
 */
