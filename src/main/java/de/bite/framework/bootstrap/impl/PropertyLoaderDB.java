/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.bootstrap.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.bootstrap.IPropertyLoader;
import de.bite.framework.factories.impl.DefaultFactory;
import de.bite.framework.service.batch.exporter.*;
import de.bite.framework.utilities.db.Datenbank;

//~--- JDK imports ------------------------------------------------------------

import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.Properties;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class PropertyLoaderDB implements IPropertyLoader
{

  //~--- methods --------------------------------------------------------------

  /**
   * 
   * @param pathOrFile String
   *
   * @return Properties[]
   *
   * @throws Exception
   */
  @Override
  public Properties[] loadProperties(String pathOrFile) throws Exception
  {
    DefaultFactory factory         = new DefaultFactory();
    String[]       pathToDBKonfigs = pathOrFile.split("@@@");
    Datenbank      datenbank       = (Datenbank)factory.getObject(pathToDBKonfigs[1]);
    String         dbPropertyPath  = pathToDBKonfigs[0];
    Properties     dbproperties    = new Properties();

    dbproperties.load(new FileInputStream(dbPropertyPath));
    datenbank.setKonfig(dbproperties);

    PropertiesExporter exporter = new PropertiesExporter(datenbank);

    return exporter.export();
  }

  // werden in dieser Klasse nicht gebraucht

  /**
   * 
   * @param pathOrFile String
   */
  @Override
  public void isInputStringValid(String pathOrFile)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   * 
   * @param pathOrFile String
   *
   * @return boolean
   */
  @Override
  public boolean isInputStringDirectory(String pathOrFile)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   * 
   * @param pathToProperty String
   */
  @Override
  public void checkSingleFileAsPropertyFile(String pathToProperty)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   * 
   * @param filesToLoad ArrayList<?>
   *
   * @return ArrayList<String>
   */
  @Override
  public ArrayList< String > extractAndAnalyzePropertiesFromDirectory(ArrayList< ? > filesToLoad)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}


/* ||\
 * ---------------------------------------------------------
 */
