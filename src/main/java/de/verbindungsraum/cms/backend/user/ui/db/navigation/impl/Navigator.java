/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.verbindungsraum.cms.backend.user.ui.db.navigation.impl.Navigator.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

package de.verbindungsraum.cms.backend.user.ui.db.navigation.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.extension.impl.ContextStatus;
import de.bite.framework.context.extension.impl.ContextType;
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
