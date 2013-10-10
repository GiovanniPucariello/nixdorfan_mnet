/**
 *
 * Copyright (c) 2013.10.04
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.verbindungsraum.gsal.threads;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.utilities.system.SystemInformation;

//~--- JDK imports ------------------------------------------------------------

import java.util.concurrent.TimeUnit;
import java.util.HashMap;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author AN
 */
public class RAMInformationThread extends DefaultGSALThread
{
  //~--- methods --------------------------------------------------------------

  /**
   */
  @Override
  public void run()
  {

    HashMap< Long, Long > sysValues = new HashMap< Long, Long >();

    this.context.setObject("sysvals", sysValues);

    try
    {
      while(true)
      {
        TimeUnit.SECONDS.sleep(5);

        HashMap< Long, Long > sysVals = (HashMap< Long, Long >)this.context.getObject("sysvals");

        sysVals.put(System.currentTimeMillis(), SystemInformation.getFreeMemoryInMB());
        this.context.getLogger().info("RAM: " + SystemInformation.getFreeMemoryInMB());
      }
    }
    catch(Exception ex)
    {
      this.context.getLogger().info(" Beende RAMInformationThread");
    }

  }
}


/* ||\
 * ---------------------------------------------------------
 */
