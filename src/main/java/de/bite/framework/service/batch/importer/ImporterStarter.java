/**
 *
 * Copyright (c) 2013.10.04
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.service.batch.importer;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.bootstrap.impl.Bootstrap;
import de.bite.framework.context.IContext;

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
