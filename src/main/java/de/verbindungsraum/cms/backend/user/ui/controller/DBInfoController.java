/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.verbindungsraum.cms.backend.user.ui.controller.DBInfoController.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

package de.verbindungsraum.cms.backend.user.ui.controller;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.controller.impl.AbstractController;

import de.verbindungsraum.cms.backend.user.ui.CMSDBKonfigurator;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class DBInfoController extends AbstractController
{
  //~--- methods --------------------------------------------------------------

  /**
   */
  @Override
  public void dispatch()
  {
    CMSDBKonfigurator konfig = (CMSDBKonfigurator)this.iContext.getObject("cms.ui.dbkonf", ContextType.NEW, null);

    konfig.initTree();
    konfig.setVisible(true);
  }

  /**
   *
   * @return boolean
   */
  @Override
  public boolean isSuccessful()
  {
    return true;
  }

  /**
   *
   * @return String
   */
  @Override
  public String actualControllerState()
  {
    return "UI gestartet";
  }
}


/* ||\
 * ---------------------------------------------------------
 */
