/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

/*
* @(#)AbstractFactory.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package de.bite.framework.factories.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.constants.Constants;
import de.bite.framework.controller.Controller;
import de.bite.framework.factories.Factory;
import de.bite.framework.model.Model;
import de.bite.framework.source.Source;
import de.bite.framework.utilities.db.Datenbank;
import de.bite.framework.view.View;

import org.apache.log4j.Logger;

//~--- JDK imports ------------------------------------------------------------

import java.io.Serializable;

//~--- classes ----------------------------------------------------------------

/**
 * 21.04.2011
 * @author nixdorfan
 */
public abstract class AbstractFactory implements Factory, Serializable
{

  //~--- methods --------------------------------------------------------------

  /**
   *
   *
   * @param clazzname String
   *
   * @return Object
   */
  @Override
  public Object getObject(String clazzname)
  {
    try
    {
      Class< ? > getGeneralObject = Class.forName(clazzname);

      return getGeneralObject.newInstance();
    }
    catch(Exception ex)
    {
      throw new RuntimeException(ex);
    }
  }

  /**
   *
   * @param clazz String
   *
   * @return Model
   */
  @Override
  public Model getModel(String clazz)
  {
    try
    {
      Class< ? > getModelClass = Class.forName(clazz);

      return(Model)getModelClass.newInstance();
    }
    catch(Exception ex)
    {
      throw new RuntimeException(ex);
    }
  }

  /**
   *
   * @param clazz String
   *
   * @return Controller
   */
  @Override
  public Controller getController(String clazz)
  {
    try
    {
      Class< ? > getController = Class.forName(clazz);

      return(Controller)getController.newInstance();
    }
    catch(Exception ex)
    {
      throw new RuntimeException(ex);
    }
  }

  /**
   *
   * @param clazz String
   *
   * @return View
   */
  @Override
  public View getView(String clazz)
  {
    try
    {
      Class< ? > getViewClass = Class.forName(clazz);

      return(View)getViewClass.newInstance();
    }
    catch(Exception ex)
    {
      throw new RuntimeException(ex);
    }
  }

  /**
   *
   * @param clazz String
   *
   * @return Source
   */
  @Override
  public Source getSource(String clazz)
  {
    try
    {
      Class< ? > getSourceClass = Class.forName(clazz);

      return(Source)getSourceClass.newInstance();
    }
    catch(Exception ex)
    {
      throw new RuntimeException(ex);
    }
  }

  /**
   *
   * @param clazz String
   *
   * @return Datenbank
   */
  @Override
  public Datenbank getDatabaseObject(String clazz)
  {
    try
    {
      Class< ? > getDatenbankObjectClass = Class.forName(clazz);

      return(Datenbank)getDatenbankObjectClass.newInstance();
    }
    catch(Exception ex)
    {
      throw new RuntimeException(ex);
    }
  }
}


/* ||\
 * ---------------------------------------------------------
 */
