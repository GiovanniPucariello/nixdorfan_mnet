/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.verbindungsraum.cms.backend.user.ui.db.querybuilder.IQueryBuilder.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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
