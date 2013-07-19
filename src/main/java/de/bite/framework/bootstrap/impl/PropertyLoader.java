/**
 *
 * Copyright (c) 2013.06.14
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0-b147
 * 
 */

/*
* @(#)PropertyLoader.java   11/12/16
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.bootstrap.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.bootstrap.IPropertyLoader;
import de.bite.framework.constants.Constants;
import de.bite.framework.utilities.file.FileHandler;
import de.bite.framework.utilities.file.FileUtilsAN;

import org.apache.log4j.Logger;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.Properties;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class PropertyLoader implements IPropertyLoader
{

  //~--- fields ---------------------------------------------------------------

  Logger logger = Logger.getLogger(PropertyLoader.class);

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param pathOrFile String
   *
   * @return Properties[]
   *
   * @throws Exception
   */
  public Properties[] loadProperties(String pathOrFile) throws Exception
  {

    FileHandler         loader      = new FileHandler();
    Properties[]        configs     = null;
    ArrayList< String > filesToLoad = null;

    this.isInputStringValid(pathOrFile);

    if(!this.isInputStringDirectory(pathOrFile))
    {
      checkSingleFileAsPropertyFile(pathOrFile);

      filesToLoad = new ArrayList< String >(1);
      configs     = new Properties[1];

      Properties properties = new Properties();

      properties.load(new FileInputStream(pathOrFile));

      configs[0] = properties;

      logger.info(Constants.info_message + "Einzelnes Property-File geladen :: " + pathOrFile);
    }
    else
    {
      filesToLoad = this.extractAndAnalyzePropertiesFromDirectory(loader.getPathsAndFiles(pathOrFile));
      configs     = new Properties[filesToLoad.size()];

      int load = 0;

      for(Object pathToProperty : filesToLoad)
      {
        Properties properties = new Properties();

        properties.load(new FileInputStream(pathToProperty + ""));

        configs[load] = properties;

        load++;

        logger.info(Constants.info_message + "Property-File geladen :: " + pathToProperty);
      }
    }

    return configs;

  }

  /**
   *
   * @param pathOrFile String
   *
   * @throws Exception
   */
  public void isInputStringValid(String pathOrFile) throws Exception
  {
    if((pathOrFile == null) || (pathOrFile == ""))
    {
      throw new Exception("Argument fuer Properties-Liste nicht valide");
    }
  }

  /**
   *
   * @param pathOrFile String
   *
   * @return boolean
   */
  public boolean isInputStringDirectory(String pathOrFile)
  {
    return FileUtilsAN.isDirectory(new File(pathOrFile));
  }

  /**
   *
   * @param pathToProperty String
   *
   * @throws Exception
   */
  public void checkSingleFileAsPropertyFile(String pathToProperty) throws Exception
  {
    if((!pathToProperty.toString().startsWith("File") && !pathToProperty.toString().endsWith(".mod_properties")) || pathToProperty.toString().endsWith("log4j.properties"))
    {
      throw new Exception("Einzelproperty konnte nicht verifiziert werden ");
    }
  }

  /**
   *
   * @param filesToLoad ArrayList<?>
   *
   * @return ArrayList<String>
   */
  public ArrayList< String > extractAndAnalyzePropertiesFromDirectory(ArrayList< ? > filesToLoad)
  {
    ArrayList< String > extractedFiles = new ArrayList< String >();

    for(Object pathToProperty : filesToLoad)
    {
      String trimmedPath = "";

      if(pathToProperty.toString().startsWith("File") && pathToProperty.toString().endsWith(".mod_properties") && !pathToProperty.toString().endsWith("log4j.properties"))
      {
        trimmedPath = pathToProperty.toString().substring(6);

        extractedFiles.add(trimmedPath);
      }
      else
      {
        logger.info(Constants.info_message + "File zum Einlesen nicht geeignet :: " + pathToProperty);
      }
    }

    return extractedFiles;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
