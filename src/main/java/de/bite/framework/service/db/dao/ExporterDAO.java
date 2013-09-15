/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.service.db.dao.ExporterDAO.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

package de.bite.framework.service.db.dao;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.utilities.db.Datenbank;

//~--- JDK imports ------------------------------------------------------------

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Properties;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class ExporterDAO
{
  //~--- methods --------------------------------------------------------------

  // hole Daten aus Datenbank und generiere Properties-Dateien

  /**
   *
   * @param datenbank Datenbank
   *
   * @return Properties[]
   *
   * @throws SQLException
   */
  public Properties[] getProperties(Datenbank datenbank) throws SQLException
  {

    String                  sqlForApps   = "select name from applications";
    ResultSet               resultApps   = datenbank.execStmt(sqlForApps);
    ArrayList< Properties > propertyList = new ArrayList< Properties >();

    while(resultApps.next())
    {
      Properties actualProps = new Properties();

      actualProps.setProperty("name", resultApps.getString("name"));
      propertyList.add(actualProps);
    }

    resultApps.close();

    Properties[] returnProps = new Properties[propertyList.size()];
    int          count       = 0;

    for(Properties actPro : propertyList)
    {
      String name = actPro.getProperty("name");
      String sql  = "select * from applications_key_value where name = '" + name + "'";

      System.out.println(sql);

      ResultSet actPropRes = datenbank.execStmt(sql);

      while(actPropRes.next())
      {
        actPro.setProperty(actPropRes.getString("app_key"), actPropRes.getString("app_value"));
      }

      actPropRes.close();

      returnProps[count] = actPro;

      count++;
    }

    return returnProps;

  }
}


/* ||\
 * ---------------------------------------------------------
 */
