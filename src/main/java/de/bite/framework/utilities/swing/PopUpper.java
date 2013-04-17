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

    // JOptionPane.showConfirmDialog(contentPane,forPopUp, forPopUp,JOptionPane.OK_CANCEL_OPTION);
  }
}


/* ||\
 * ---------------------------------------------------------
 */
