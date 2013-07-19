/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.verbindungsraum.gsal.threads;

import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.utilities.system.SystemInformation;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author AN
 */
public class RAMInformationThread  extends DefaultGSALThread {
    
    @Override
    public void run(){
    
        HashMap<Long,Long> sysValues = new HashMap<Long,Long>();
        this.context.setObject("sysvals", sysValues);
        
        try
        {
          while(true)
          {  
            TimeUnit.SECONDS.sleep(5);
            HashMap<Long,Long> sysVals = (HashMap<Long,Long>)this.context.getObject("sysvals");
            sysVals.put(System.currentTimeMillis(), SystemInformation.getFreeMemoryInMB());
            this.context.getLogger().info("RAM: "+ SystemInformation.getFreeMemoryInMB());
          }
        }
        catch(Exception ex)
        {
          this.context.getLogger().info(" Beende RAMInformationThread");
        }
        
    }
}
