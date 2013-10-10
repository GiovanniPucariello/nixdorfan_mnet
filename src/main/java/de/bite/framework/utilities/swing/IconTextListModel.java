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
* @(#)IconTextListModel.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.swing;

//~--- JDK imports ------------------------------------------------------------

import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.Icon;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class IconTextListModel extends AbstractListModel
{
  //~--- fields ---------------------------------------------------------------

  private Vector del = new Vector();

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @return int
   */
  @Override
  public int getSize()
  {
    return del.size();
  }

  /**
   *
   * @param index int
   *
   * @return Object
   */
  @Override
  public Object getElementAt(int index)
  {
    return del.elementAt(index);
  }

  /**
   *
   * @param ic Icon
   * @param text Object
   */
  public void add(Icon ic, Object text)
  {
    int index = del.size();

    del.add(new Object[]{ ic, "" + text });
    fireIntervalAdded(this, index, index);
  }

  /**
   *
   * @param index int
   */
  public void remove(int index)
  {
    if((index > -1) && (index < del.size()))
    {
      del.remove(index);
      fireIntervalRemoved(this, index, index);
    }
    else
    {
      throw new ArrayIndexOutOfBoundsException("index =" + index);
    }
  }
}


/* ||\
 * ---------------------------------------------------------
 */
