/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.service.batch.exporter.controller;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.controller.impl.AbstractController;
import de.bite.framework.service.batch.importer.PropertiesImporter;

//~--- JDK imports ------------------------------------------------------------

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan    
 */
public class ModulServiceImporter extends AbstractController
{
  //~--- methods --------------------------------------------------------------

  /**
   */
  @Override
  public void dispatch()
  {

    // Properties
    Properties         dbproperties = new Properties();
    PropertiesImporter importer     = new PropertiesImporter();

    try
    {
      dbproperties.load(new FileInputStream(this.iContext.getStringValueFromProperties("service.db")));
      importer.load(this.iContext.getStringValueFromProperties("service.directorypath"));
      importer.cleanAndBuildDataBase(dbproperties, this.iContext);
      importer.importProperties(dbproperties, this.iContext);
    }
    catch(FileNotFoundException ex)
    {
      this.iContext.getLogger().error("FileNotFoundException" + ex.getLocalizedMessage());
      ex.printStackTrace();
    }
    catch(IOException ex)
    {
      this.iContext.getLogger().error("IOException" + ex.getLocalizedMessage());
      ex.printStackTrace();
    }
    catch(Exception ex)
    {
      this.iContext.getLogger().error("Exception" + ex.getLocalizedMessage());
      ex.printStackTrace();
    }
  }

  /**
   *
   * @return boolean
   */
  @Override
  public boolean isSuccessful()
  {
    return true;
  }

  /**
   *
   * @return String
   */
  @Override
  public String actualControllerState()
  {
    return null;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
