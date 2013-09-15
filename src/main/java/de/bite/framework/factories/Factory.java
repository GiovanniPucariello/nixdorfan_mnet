/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.factories.Factory.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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
