/**
 *
 * Copyright (c) 2013.06.14
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0-b147
 * 
 */

package de.bite.framework.service.batch.importer;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.bootstrap.impl.PropertyLoader;
import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.context.IContext;
import de.bite.framework.service.db.dao.ImporterDAO;
import de.bite.framework.utilities.db.Datenbank;

//~--- JDK imports ------------------------------------------------------------

import java.util.Enumeration;
import java.util.Properties;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class PropertiesImporter
{

  //~--- fields ---------------------------------------------------------------

  private Properties[] propList;

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param directoryPath String
   *
   * @throws Exception
   */
  public void load(String directoryPath) throws Exception
  {
    if(propList != null)
    {
      propList = null;
    }

    try
    {
      PropertyLoader loader = new PropertyLoader();

      propList = loader.loadProperties(directoryPath);
    }
    catch(Exception ex)
    {
      throw new Exception("Fehler beim Laden der Properties");
    }
  }

  /**
   *
   * @param dbprops Properties
   * @param context IContext
   *
   * @return Boolean
   */
  public Boolean importProperties(Properties dbprops, IContext context)
  {

    ImporterDAO importer = new ImporterDAO(dbprops, context);

    for(int i = 0; i < propList.length; i++)
    {
      Properties singleProp = propList[i];

      importer.insertPropertyName(singleProp.getProperty("name"));

      Enumeration< Object > enumeration = singleProp.keys();

      while(enumeration.hasMoreElements())
      {
        String key   = (String)enumeration.nextElement();
        String value = singleProp.getProperty(key);

        importer.insertPropertyKeyValue(key, value, singleProp.getProperty("name"));
      }
    }

    importer.closeImporter();

    return true;

  }

  /**
   *
   * @param dbprops Properties
   * @param context IContext
   */
  public void cleanAndBuildDataBase(Properties dbprops, IContext context)
  {
    ImporterDAO importer  = new ImporterDAO(dbprops, context);
    String      deleteSQL = context.getStringValueFromProperties("service.db.clean");

    importer.clean(deleteSQL);
    importer.closeImporter();
  }
}


/* ||\
 * ---------------------------------------------------------
 */
