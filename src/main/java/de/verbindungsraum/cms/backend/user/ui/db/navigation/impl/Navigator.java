/**
 *
 * Copyright (c) 2013.10.04
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.verbindungsraum.cms.backend.user.ui.db.navigation.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.IContext;

import de.verbindungsraum.cms.backend.user.ui.db.navigation.INavigator;

//~--- JDK imports ------------------------------------------------------------

import java.util.LinkedList;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class Navigator implements INavigator
{

  //~--- fields ---------------------------------------------------------------

  private IContext             context;
  private LinkedList< String > forward  = new LinkedList< String >();
  private LinkedList< String > backward = new LinkedList< String >();
  private String               actual;

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param context IContext
   */
  @Override
  public void setContext(IContext context)
  {
    this.context = context;
  }

  /**
   *
   * @return String
   */
  @Override
  public String getActualNavigationPoint()
  {
    return actual;
  }

  /**
   *
   * @param actualSQL String
   */
  @Override
  public void setActualNavigationPoint(String actualSQL)
  {
    if(this.actual != null)
    {
      backward.add(this.actual);

      this.actual = actualSQL;
    }
    else
    {
      this.actual = actualSQL;
    }
  }

  /**
   *
   * @return String
   */
  @Override
  public String getBackwardNavigationPoint()
  {
    if(backward.isEmpty())
    {
      return "Cache leer";
    }
    else
    {
      String last = backward.pollLast();

      forward.add(last);

      return last;
    }
  }

  /**
   *
   * @return String
   */
  @Override
  public String getForwardNavigationPoint()
  {
    if(forward.isEmpty())
    {
      return "noch kein Cache aufgebaut";
    }
    else
    {
      String next = forward.pollLast();

      backward.add(next);

      return next;
    }
  }
}


/* ||\
 * ---------------------------------------------------------
 */
