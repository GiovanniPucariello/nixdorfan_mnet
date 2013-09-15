/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.verbindungsraum.cms.backend.user.ui.db.navigation.INavigator.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

package de.verbindungsraum.cms.backend.user.ui.db.navigation;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.IContext;

//~--- interfaces -------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public interface INavigator
{
  //~--- methods --------------------------------------------------------------

  /**
   *
   * @return String
   */
  String getActualNavigationPoint();

  /**
   *
   * @return String
   */
  String getBackwardNavigationPoint();

  /**
   *
   * @return String
   */
  String getForwardNavigationPoint();

  /**
   *
   * @param actualSQL String
   */
  void setActualNavigationPoint(String actualSQL);

  /**
   *
   * @param context IContext
   */
  void setContext(IContext context);
}


/* ||\
 * ---------------------------------------------------------
 */
