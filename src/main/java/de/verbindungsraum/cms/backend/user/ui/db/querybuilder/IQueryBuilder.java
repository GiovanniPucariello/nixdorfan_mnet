/**
 *
 * Copyright (c) 2013.06.14
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0-b147
 * 
 */

package de.verbindungsraum.cms.backend.user.ui.db.querybuilder;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.IContext;

//~--- JDK imports ------------------------------------------------------------

import java.util.HashMap;

//~--- interfaces -------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public interface IQueryBuilder
{
  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param context IContext
   */
  public void setContext(IContext context);

  /**
   *
   * @param SQL String
   *
   * @return HashMap<String,String>
   */
  public HashMap< String, String > getResult(String SQL);
}


/* ||\
 * ---------------------------------------------------------
 */
