/**
 *
 * Copyright (c) 2013.06.14
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0-b147
 * 
 */

package de.verbindungsraum.gsal.threads;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.IContext;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class DefaultGSALThread implements Runnable
{
  //~--- fields ---------------------------------------------------------------

  public IContext context;

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param context IContext
   */
  public void setContext(IContext context)
  {
    this.context = context;
  }

  /**
   */
  @Override
  public void run()
  {
    this.context.getLogger().info("DefaultRunnable");

    return;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
