/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.service.batch.importer.ImporterStarter.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

package de.bite.framework.service.batch.importer;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.bootstrap.impl.Bootstrap;
import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.context.IContext;
import de.bite.framework.controller.Controller;
import de.bite.framework.service.batch.exporter.PropertiesExporter;

//~--- JDK imports ------------------------------------------------------------

import java.io.FileInputStream;

import java.util.Properties;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class ImporterStarter
{
  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param args String[]
   */
  public static void main(String[] args)
  {
    try
    {

      /** B o o t s t r a p Context */
      IContext           context      = Bootstrap.startContext(args[0]);
      PropertiesImporter importer     = new PropertiesImporter();

      // Properties
      Properties         dbproperties = new Properties();

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


/* ||\
 * ---------------------------------------------------------
 */
