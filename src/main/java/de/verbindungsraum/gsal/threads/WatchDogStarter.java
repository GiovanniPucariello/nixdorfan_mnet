/**
 *
 * Copyright (c) 2013.01.25
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.verbindungsraum.gsal.threads;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.extension.impl.ContextType;

//~--- JDK imports ------------------------------------------------------------

import java.nio.file.*;

import java.util.concurrent.TimeUnit;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class WatchDogStarter extends DefaultGSALThread
{
  //~--- methods --------------------------------------------------------------

  /**
   */
  @Override
  public void run()
  {

    try
    {
      WatchService watcher      = FileSystems.getDefault().newWatchService();
      String       observedPath = (String)this.context.getObject("basepath", ContextType.USED, null);

      Paths.get(observedPath).register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

      while(true)
      {

        // TimeUnit.SECONDS.sleep(5);
        WatchKey key = watcher.take();

        for(WatchEvent< ? > event : key.pollEvents())
        {
          this.context.getLogger().info("WatchDogStarter detect event on GSAL-Filesystem: " + event.kind() + ", on File " + event.context());
          this.context.updateContextConfiguration(event.context()+"");
        }

        key.reset();
      }
    }
    catch(Exception ex)
    {
      this.context.getLogger().error(" WatchserviceThread " + ex);
    }

  }
}


/* ||\
 * ---------------------------------------------------------
 */
