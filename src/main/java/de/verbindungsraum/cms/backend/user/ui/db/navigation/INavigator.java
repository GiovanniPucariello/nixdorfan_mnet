/**
 *
 * Copyright (c) 2013.10.04
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
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
