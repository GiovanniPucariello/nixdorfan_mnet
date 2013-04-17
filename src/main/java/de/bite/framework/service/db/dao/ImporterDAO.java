/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.service.db.dao;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.context.IContext;
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
public class ImporterDAO
{

  //~--- fields ---------------------------------------------------------------

  private IContext  context;
  private Datenbank datenbank;

  //~--- constructors ---------------------------------------------------------

  /**
   *
   * @param db Properties
   * @param context IContext
   */
  public ImporterDAO(Properties db, IContext context)
  {
    this.context   = context;
    this.datenbank = (Datenbank)context.getObject("default.datenbank", ContextType.NEW, null);

    datenbank.setKonfig(db);
  }




  //~--- methods --------------------------------------------------------------

  // welche AppliKationen gibt es

  /**
   * 
   * @param name String
   *
   * @return boolean
   */
  public boolean insertPropertyName(String name)
  {
    String sql    = "insert into applications (aid,name,app_id) values (" + this.context.getStringValueFromProperties("service.db.sequence.nameid") + ",'" + name + "'," +
                 this.context.getStringValueFromProperties("service.db.sequence.nameappid") + ")";
    int    result = this.datenbank.execDMLStmt(sql);

    if(result == 0)
    {
      this.context.getLogger().error(sql);

      return false;
    }
    else
    {
      this.context.getLogger().info("Datensatz eingetragen");

      return true;
    }
  }

  // welche Werte haben diese Applikationen?

  /**
   * 
   * @param key String
   * @param value String
   * @param name String
   *
   * @return boolean
   */
  public boolean insertPropertyKeyValue(String key, String value, String name)
  {
    String sql    = "insert into applications_key_value (akvid,app_key,app_value,name,fk_app_id) values (" + this.context.getStringValueFromProperties("service.db.sequence.keyvalue") + ",'" + key +
                 "'," + "'" + value + "'," + "'" + name + "',(select app_id from applications where name ='" + name + "'" + ") )";
    int    result = this.datenbank.execDMLStmt(sql);

    if(result == 0)
    {
      this.context.getLogger().error(sql);

      return false;
    }
    else
    {
      this.context.getLogger().info("Datensatz eingetragen");

      return true;
    }
  }

  // Bereinige Datenbanken

  /**
   * 
   * @param cleanSQL String
   *
   * @return boolean
   */
  public boolean clean(String cleanSQL)
  {
    int result = this.datenbank.execDMLStmt(cleanSQL);

    if(result == 0)
    {
      this.context.getLogger().error(cleanSQL);

      return false;
    }
    else
    {
      this.context.getLogger().info("Datenbank bereinigt");

      return true;
    }
  }

  /**
   */
  public void closeImporter()
  {
    this.datenbank.closeStatementAndConnection();
  }
}


/* ||\
 * ---------------------------------------------------------
 */
