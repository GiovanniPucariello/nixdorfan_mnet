/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bite.framework.service.batch.importer;

import de.bite.framework.bootstrap.impl.Bootstrap;
import de.bite.framework.context.IContext;
import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.controller.Controller;
import de.bite.framework.service.batch.exporter.PropertiesExporter;
import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author nixdorfan
 */
public class ImporterStarter {
    
    public static void main(String[] args){
  
    try
    {

      /** B o o t s t r a p Context */
      IContext   context  = Bootstrap.startContext(args[0]);
      PropertiesImporter importer = new PropertiesImporter();
      
      // Properties
      Properties dbproperties = new Properties();
      dbproperties.load(new FileInputStream(context.getStringValueFromProperties("service.db")));
      
      importer.load(context.getStringValueFromProperties("service.directorypath"));
      importer.cleanAndBuildDataBase(dbproperties, context);
      importer.importProperties(dbproperties, context);
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
    }
}
}

