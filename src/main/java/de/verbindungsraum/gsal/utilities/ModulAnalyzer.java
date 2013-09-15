/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.verbindungsraum.gsal.utilities.ModulAnalyzer.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

/*
* @(#)ModulAnalyzer.java   12/10/05
*
* @author nixdorfan
 */
package de.verbindungsraum.gsal.utilities;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.bootstrap.impl.PropertyLoader;
import de.bite.framework.constants.Constants;

import de.verbindungsraum.gsal.exception.GSALException;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Font;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JMenuItem;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class ModulAnalyzer
{

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param pathToFileOrDirectory String
   *
   * @return List<JMenuItem>
   *
   * @throws GSALException
   */
  public static List< JMenuItem > getActualItems(String pathToFileOrDirectory) throws GSALException
  {

    List< JMenuItem > itemList = new ArrayList< JMenuItem >();

    try
    {
      PropertyLoader loader         = new PropertyLoader();
      Properties[]   propertiesList = loader.loadProperties(pathToFileOrDirectory);

      for(Properties property : propertiesList)
      {
        if(property.getProperty("name").equalsIgnoreCase("base") || property.getProperty("name").equalsIgnoreCase("default"))
        {

          // diese Werte werden nicht in die Modulstarterliste uebernommen
        }
        else
        {
          JMenuItem item = new JMenuItem();

          item.setText(property.getProperty("name"));
          item.setToolTipText(property.getProperty("description"));
          item.setFont(new Font("Arial", 0, 10));
          itemList.add(item);
        }
      }
    }
    catch(Exception ex)
    {
      throw new GSALException(Constants.error_message + " " + ex.getLocalizedMessage());
    }

    return itemList;

  }

  /**
   *
   * @param pathToFileOrDirectory String
   *
   * @return List<JMenuItem>
   *
   * @throws GSALException
   */
  public static List< String > getActualItemsForConsole(String pathToFileOrDirectory) throws GSALException
  {

    List< String > itemList = new ArrayList< String >();

    try
    {
      PropertyLoader loader         = new PropertyLoader();
      Properties[]   propertiesList = loader.loadProperties(pathToFileOrDirectory);

      for(Properties property : propertiesList)
      {
        if(!property.getProperty("name").equalsIgnoreCase("base") || !property.getProperty("name").equalsIgnoreCase("default"))
        {
          itemList.add(property.getProperty("name"));
        }
      }
    }
    catch(Exception ex)
    {
      throw new GSALException(Constants.error_message + " " + ex.getLocalizedMessage());
    }

    return itemList;

  }
}


/* ||\
 * ---------------------------------------------------------
 */
