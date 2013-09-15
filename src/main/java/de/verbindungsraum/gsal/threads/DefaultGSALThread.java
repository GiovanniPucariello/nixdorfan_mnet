/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.verbindungsraum.gsal.threads.DefaultGSALThread.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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
