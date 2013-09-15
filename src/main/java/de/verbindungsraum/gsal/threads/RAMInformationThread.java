/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.verbindungsraum.gsal.threads.RAMInformationThread.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

package de.verbindungsraum.gsal.threads;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.utilities.system.SystemInformation;

//~--- JDK imports ------------------------------------------------------------

import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

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
