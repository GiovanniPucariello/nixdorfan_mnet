/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.view.View.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package de.bite.framework.view;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.IContext;

//~--- interfaces -------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public interface View
{
  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param iContext Context
   */
  public void setContext(IContext iContext);

  /**
   *
   * @return boolean
   */
  public boolean processOutput();
}


/* ||\
 * ---------------------------------------------------------
 */
