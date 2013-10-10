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
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package de.bite.framework.factories;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.controller.Controller;
import de.bite.framework.model.Model;
import de.bite.framework.source.Source;
import de.bite.framework.utilities.db.Datenbank;
import de.bite.framework.view.View;

//~--- interfaces -------------------------------------------------------------

/**
 * 21.04.2011
 * @author nixdorfan
 */
public interface Factory
{
  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param clazz String
   *
   * @return Object
   */
  public Object getObject(String clazz);

  /**
   *
   * @param clazz String
   *
   * @return Model
   */
  public Model getModel(String clazz);

  /**
   *
   * @param clazz String
   *
   * @return Controller
   */
  public Controller getController(String clazz);

  /**
   *
   * @param clazz String
   *
   * @return View
   */
  public View getView(String clazz);

  /**
   *
   * @param clazz String
   *
   * @return Source
   */
  public Source getSource(String clazz);

  /**
   *
   * @param clazz String
   *
   * @return Datenbank
   */
  public Datenbank getDatabaseObject(String clazz);
}


/* ||\
 * ---------------------------------------------------------
 */
