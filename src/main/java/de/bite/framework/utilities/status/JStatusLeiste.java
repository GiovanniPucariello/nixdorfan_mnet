/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.utilities.status.JStatusLeiste.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

/*
* @(#)JStatusLeiste.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.status;

//~--- JDK imports ------------------------------------------------------------

//------------------------------------------------------------------------------
//maincomments

/*
==========================================================================================================================
JStatusLeiste
Copyright c 2006
{( programmierloesungen )
        Dr. rer. nat. Andreas Nixdorf
        Erhard-Auer-Str. 5
        Muehldorf am Inn;
        Tel.: auf e-mail-Anfrage
        www.verbindungsraum.de
}
==========================================================================================================================
*/

//------------------------------------------------------------------------------
//imports
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class JStatusLeiste extends JPanel
{

  //~--- fields ---------------------------------------------------------------

//------------------------------------------------------------------------------
//members
  // clock
  JClock jC              = new JClock();
  JLabel statusLabel     = new JLabel();

  // panels for embedding components
  JPanel panOverall_EAST = new JPanel(new BorderLayout());
  JPanel panOverall      = new JPanel(new BorderLayout());
  JPanel panInset        = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 1));

  //~--- constructors ---------------------------------------------------------

  // Konstruktor mit implementierter Borderlayout-Uebergabe

  /**
   */
  public JStatusLeiste()
  {
    super(new BorderLayout());

    initStatus();
  }




//------------------------------------------------------------------------------
//constructor

  /**
   *
   * @param b BorderLayout
   */
  public JStatusLeiste(BorderLayout b)
  {
    super(b);

    initStatus();
  }




  //~--- methods --------------------------------------------------------------

//------------------------------------------------------------------------------
//constructor methods

  /**
   */
  public void initStatus()
  {
    statusLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
    panOverall_EAST.setOpaque(true);
    panInset.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
    panInset.setOpaque(true);
    panOverall.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
    panOverall.setOpaque(true);
    panOverall_EAST.add(panInset, BorderLayout.CENTER);
    panOverall_EAST.add(jC, BorderLayout.EAST);
    panOverall.add(statusLabel, BorderLayout.CENTER);
    panOverall.add(panOverall_EAST, BorderLayout.EAST);
    this.add(panOverall, BorderLayout.SOUTH);
  }

//------------------------------------------------------------------------------
//class methods

  /**
   * adding a new component to the JStatusLeiste
   *  every component can be added
   *  addComp(javax.swing.JComponent compo)
   *
   * @param compo javax.swing.JComponent
   */
  public void addComp(javax.swing.JComponent compo)
  {
    panInset.add(compo);
  }

  /**
   * deleting a component from JStatusLeiste
   *  removeComp(javax.swing.JComponent compo)
   *
   * @param compo javax.swing.JComponent
   */
  public void removeComp(javax.swing.JComponent compo)
  {
    panInset.remove(compo);
  }

  /**
   * get the components from JStatusLeiste
   *  Component [] getComp()
   *
   * @return Component[]
   */
  public Component[] getComp()
  {
    return panInset.getComponents();
  }

  /**
   * set label-text
   *
   * @param l String
   */
  public void addLabelText(String l)
  {
    statusLabel.setText(l);
  }

  /** delete label-text */
  public void removeLabelText()
  {
    statusLabel.setText("");
  }
}


/* ||\
 * ---------------------------------------------------------
 */
