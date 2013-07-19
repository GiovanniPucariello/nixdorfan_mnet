/**
 *
 * Copyright (c) 2013.06.14
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0-b147
 * 
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
