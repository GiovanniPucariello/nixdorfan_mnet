/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.verbindungsraum.gsal.threads.RAMInformationThread.java 1.0 | 2013.12.13 bas | UTF8 | tab 2
 */

package de.verbindungsraum.gsal.threads;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.utilities.system.SystemInformation;

//~--- JDK imports ------------------------------------------------------------

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

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

    HashMap< Long, Long > freeMemory = new HashMap< Long, Long >();
    HashMap< Long, Long > usedMemory = new HashMap< Long, Long >();
    HashMap< Long, Long > maxMemory  = new HashMap< Long, Long >();
    MemoryMXBean          mBean      = ManagementFactory.getMemoryMXBean();

    this.context.setObject("freeMemory", freeMemory);
    this.context.setObject("usedMemory", usedMemory);
    this.context.setObject("maxMemory", maxMemory);

    try
    {
      while(true)
      {
        TimeUnit.SECONDS.sleep(5);

        freeMemory = (HashMap< Long, Long >)this.context.getObject("freeMemory");
        usedMemory = (HashMap< Long, Long >)this.context.getObject("usedMemory");
        maxMemory  = (HashMap< Long, Long >)this.context.getObject("maxMemory");

        Long actual  = System.currentTimeMillis();
        Long free    = ((((mBean.getHeapMemoryUsage().getMax()) / 1024 / 1024) - (mBean.getHeapMemoryUsage().getUsed()) / 1024 / 1024));
        Long maximal = (((mBean.getHeapMemoryUsage().getMax()) / 1024 / 1024));
        Long used    = (mBean.getHeapMemoryUsage().getUsed() / 1024 / 1024);

        freeMemory.put(actual, free);
        usedMemory.put(actual, used);
        maxMemory.put(actual, maximal);
        this.context.getLogger().info("RAM [benutzt]: " + used + " MB    ||   RAM [verfuegbar]: " + maximal + " MB");
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
