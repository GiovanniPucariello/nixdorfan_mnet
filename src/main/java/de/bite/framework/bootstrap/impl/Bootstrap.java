/**
 *
 * Copyright (c) 2013.02.20
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
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
import de.bite.framework.context.IContext;
import de.bite.framework.context.impl.DefaultContext;
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
      IContext       iContext = new DefaultContext();
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
}


/* ||\
 * ---------------------------------------------------------
 */
