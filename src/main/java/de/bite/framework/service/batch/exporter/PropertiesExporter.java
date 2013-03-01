/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bite.framework.service.batch.exporter;

import de.bite.framework.context.IContext;
import de.bite.framework.service.db.dao.ExporterDAO;
import de.bite.framework.service.db.dao.ImporterDAO;
import de.bite.framework.utilities.db.Datenbank;
import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author nixdorfan
 */
public class PropertiesExporter {
    
    
    private Datenbank datenbank;
    private String dbkonfigurations;
    
    public PropertiesExporter(Datenbank datenbank){
        this.datenbank = datenbank;
    } 
    
    public Properties[] export() throws Exception{
          // Properties
      ExporterDAO exporter = new ExporterDAO(); 
      Properties[] list = exporter.getProperties(this.datenbank);
      return list;
    }
}
