/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.utilities.swing.PopUpper.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

/*
* @(#)PopUpper.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.swing;

//~--- JDK imports ------------------------------------------------------------

//package mpianalyze;
//weitere notwendige imports
import java.awt.Container;

import javax.swing.JOptionPane;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class PopUpper
{
  //~--- fields ---------------------------------------------------------------

  private Container contentPane;
  private String    forPopUp;

  //~--- methods --------------------------------------------------------------

//Konstruktor

  /**
   *
   * @param contentPane Container
   */
  public void setVars(Container contentPane)
  {
    this.contentPane = contentPane;
  }

  /**
   *
   * @param forPopUp String
   */
  public void showPopUp(String forPopUp)
  {
    this.forPopUp = forPopUp;

    JOptionPane.showMessageDialog(contentPane, forPopUp);
  }
}


/* ||\
 * ---------------------------------------------------------
 */
