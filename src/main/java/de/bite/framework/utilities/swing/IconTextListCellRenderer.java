/**
 *
 * Copyright (c) 2012.03.08
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_01-b08
 * 
 */

/*
* @(#)IconTextListCellRenderer.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.swing;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class IconTextListCellRenderer extends JLabel implements ListCellRenderer
{
  //~--- initializers ---------------------------------------------------------

  {
    setOpaque(true);
  }

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param list JList
   * @param value Object
   * @param index int
   * @param isSelected boolean
   * @param cellHasFocus boolean
   *
   * @return Component
   */
  @Override
  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
  {

    if(isSelected)
    {
      setBackground(list.getSelectionBackground());
      setForeground(list.getSelectionForeground());
    }
    else
    {
      setBackground(list.getBackground());
      setForeground(list.getForeground());
    }

    if(value instanceof Object[])
    {
      Object[] arr = (Object[])value;
      Icon     ic  = (Icon)arr[0];

      setIcon(ic);
      setText("" + arr[1]);
    }

    return this;

  }
}


/* ||\
 * ---------------------------------------------------------
 */
