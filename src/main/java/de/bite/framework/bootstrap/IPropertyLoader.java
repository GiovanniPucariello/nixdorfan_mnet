/**
 *
 * Copyright (c) 2013.06.14
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0-b147
 * 
 */

package de.bite.framework.bootstrap;

//~--- JDK imports ------------------------------------------------------------

import java.util.ArrayList;
import java.util.Properties;

//~--- interfaces -------------------------------------------------------------

public interface IPropertyLoader
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
  public abstract Properties[] loadProperties(String pathOrFile) throws Exception;

  /**
   *
   * @param pathOrFile String
   *
   * @throws Exception
   */
  public void isInputStringValid(String pathOrFile) throws Exception;

  /**
   *
   * @param pathOrFile String
   *
   * @return boolean
   *
   * @throws Exception
   */
  public boolean isInputStringDirectory(String pathOrFile) throws Exception;

  /**
   *
   * @param pathToProperty String
   *
   * @throws Exception
   */
  public void checkSingleFileAsPropertyFile(String pathToProperty) throws Exception;

  /**
   *
   * @param filesToLoad ArrayList<?>
   *
   * @return ArrayList<String>
   */
  public ArrayList< String > extractAndAnalyzePropertiesFromDirectory(ArrayList< ? > filesToLoad);
}


/* ||\
 * ---------------------------------------------------------
 */
