/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

/*
* @(#)DatenbankObj.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */

/*
* DB_Obj.java
*
* Created on 3. Oktober 2008, 14:18
*
* To change this template, choose Tools | Template Manager
* and open the template in the editor.
 */
package de.bite.framework.utilities.db.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.constants.Constants;
import de.bite.framework.context.IContext;
import de.bite.framework.utilities.crypto.hash.CryptoProcessor;
import de.bite.framework.utilities.db.Datenbank;
import de.bite.framework.utilities.db.IDBTable;

import org.apache.log4j.Logger;

//~--- JDK imports ------------------------------------------------------------

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.TreeSet;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 *
 */
public class DatenbankObj implements Datenbank
{

  //~--- static fields --------------------------------------------------------

  private static Logger logger = Logger.getLogger(DatenbankObj.class);

  //~--- fields ---------------------------------------------------------------

  Connection      con;
  Properties      dbprops;
  String          objdb;
  Statement       stmt;
  CryptoProcessor crypto = new CryptoProcessor();

  //~--- methods --------------------------------------------------------------

  /**
   * Creates a new instance of DB_Obj
   *
   * @param dbprops Properties
   *
   * @return boolean
   */
  @Override
  public boolean setKonfig(Properties dbprops)
  {
    this.dbprops = dbprops;
    objdb        = dbprops.getProperty("initdatabase");

    this.setStatement();

    return true;
  }

  /*
   *  (non-Javadoc)
   *     @see de.bite.utils.db.impl.IDatenbank#setStatement()
   */

  /**
   */
  @Override
  public void setStatement()
  {
    try
    {
      Class.forName(dbprops.getProperty("driver" + objdb));

      con = DriverManager.getConnection(dbprops.getProperty("url" + objdb), dbprops.getProperty("initialuser"), this.crypto.doAReallyHeavyDecryption(dbprops.getProperty("initialpwd")));

      logger.info(Constants.info_message + " setStatement() - createConnection URL:" + dbprops.getProperty("url" + objdb) + "INITIAL-USER: " + "PWD:*********");

      stmt = con.createStatement();
    }
    catch(Exception ex)
    {
      stmt = null;

      logger.error(Constants.error_message + " setStatement() " + dbprops.getProperty("driver" + objdb) + "  " + dbprops.getProperty("url" + objdb) + "  " + dbprops.getProperty("initialuser") +
                   "  " + dbprops.getProperty("initialpwd"));
      logger.error(Constants.error_message + " setStatement() " + ex);
    }
  }

  /*
   *  (non-Javadoc)
   *     @see de.bite.utils.db.impl.IDatenbank#closeStatementAndConnection()
   */

  /**
   */
  @Override
  public void closeStatementAndConnection()
  {
    try
    {
      this.stmt.close();
      this.con.close();
    }
    catch(SQLException ex)
    {
      logger.error(Constants.error_message + " closeStatementAndConnection() " + ex);
    }
  }

  /*
   *  (non-Javadoc)
   *     @see de.bite.utils.db.impl.IDatenbank#setObjdb()
   */

  /**
   */
  @Override
  public void setObjdb()
  {
    objdb = dbprops.getProperty("initdatabase");
  }

  /*
   *  (non-Javadoc)
   *     @see de.bite.utils.db.impl.IDatenbank#getStatement()
   */

  /**
   *
   * @return Statement
   */
  @Override
  public Statement getStatement()
  {
    return this.stmt;
  }

  /*
   *  (non-Javadoc)
   *     @see de.bite.utils.db.impl.IDatenbank#execStmt(java.lang.String)
   */

  /**
   *
   * @param query String
   *
   * @return ResultSet
   */
  @Override
  public ResultSet execStmt(String query)
  {
    try
    {
      return stmt.executeQuery(query);
    }
    catch(Exception ex)
    {
      logger.error(Constants.error_message + " execStmt() " + ex);

      return null;
    }
  }

  /*
   *  (non-Javadoc)
   *     @see de.bite.utils.db.impl.IDatenbank#execDMLStmt(java.lang.String)
   */

  /**
   *
   * @param query String
   *
   * @return int
   */
  @Override
  public int execDMLStmt(String query)
  {
    try
    {
      return stmt.executeUpdate(query);
    }
    catch(Exception ex)
    {
      logger.error(Constants.error_message + " execDMLStmt() " + ex);

      return 0;
    }
  }

  /*
   *  (non-Javadoc)
   *     @see de.bite.utils.db.impl.IDatenbank#setProps(java.util.Properties)
   */

  /**
   *
   * @param newprops Properties
   */
  @Override
  public void setProps(Properties newprops)
  {
    this.dbprops = newprops;
  }

  /*
   *  (non-Javadoc)
   *     @see de.bite.utils.db.impl.IDatenbank#getProps()
   */

  /**
   *
   * @return Properties
   */
  @Override
  public Properties getProps()
  {
    return this.dbprops;
  }

  /*
   *  (non-Javadoc)
   *     @see de.bite.utils.db.impl.IDatenbank#setNewStatement()
   */

  /**
   */
  @Override
  public void setNewStatement()
  {
    this.setStatement();
  }

  /**
   *
   * @return HashMap<String,String>
   */
  @Override
  public HashMap< String, String > getDBMetaData()
  {

    try
    {
      HashMap< String, String > informations = new HashMap< String, String >();
      DatabaseMetaData          dbMetaData   = this.con.getMetaData();

      informations.put("Part_1", "DB-Information");
      informations.put("DB-Version (Major)", dbMetaData.getDatabaseMajorVersion() + "");
      informations.put("DB-Version (Minor)", dbMetaData.getDatabaseMinorVersion() + "");
      informations.put("Produktname", dbMetaData.getDatabaseProductName() + "");
      informations.put("Produktversion", dbMetaData.getDatabaseProductVersion() + "");
      informations.put("Part_2", "Tabellen-Information");

      // get all tables within this DB
      ResultSet tables = dbMetaData.getTables(null, null, null, null);

      while(tables.next())
      {
        informations.put(tables.getString(3), tables.getString(3));
      }

      return informations;
    }
    catch(SQLException ex)
    {
      ex.printStackTrace();

      return new HashMap< String, String >();
    }

  }

  /**
   * 
   * @param tablename String
   *
   * @return HashMap<String,String>
   */
  public HashMap< String, String > getTableInformation(String tablename)
  {

    // System.out.println("getTableInformation" + tablename);
    HashMap< String, String > informations = new HashMap< String, String >();

    try
    {
      DatabaseMetaData dbMetaData = this.con.getMetaData();
      ResultSet        result     = dbMetaData.getColumns(null, null, tablename, null);

      // System.out.println("getTableInformation result" + result);
      while(result.next())
      {

        // System.out.println("getTableInformation result.next()" + result);
        String columnName = result.getString("COLUMN_NAME");
        int    columnType = result.getInt("DATA_TYPE");

        // System.out.println("Name " + columnName +" Type " + columnType);
        informations.put(columnName, columnType + "");
      }

      return informations;
    }
    catch(SQLException ex)
    {
      ex.printStackTrace();

      return new HashMap< String, String >();
    }
  }

  /**
   *
   * @return HashMap<String,String>
   */
  public HashMap< String, String > getTables()
  {

    try
    {
      HashMap< String, String > informations = new HashMap< String, String >();
      DatabaseMetaData          dbMetaData   = this.con.getMetaData();

      // get all tables within this DB
      ResultSet                 tables       = dbMetaData.getTables(null, "public", null, null);

      while(tables.next())
      {
        informations.put(tables.getString(3), tables.getString(3));
      }

      return informations;
    }
    catch(SQLException ex)
    {
      ex.printStackTrace();

      return new HashMap< String, String >();
    }

  }

  /**
   * 
   * @param context IContext
   *
   * @return ArrayList<IDBTable>
   */
  public ArrayList< IDBTable > getAggregatedTableInformation(IContext context)
  {

    HashMap< String, String > allTables = getTables();
    ArrayList< IDBTable >     tableObj  = new ArrayList< IDBTable >();

    for(String table : allTables.keySet())
    {

      // IDBTable singleTable = (IDBTable)context.getUnboundObject("default.db.table.info");
      IDBTable singleTable = new DBTable();

      singleTable.setTablename(table);

      HashMap< String, String > tableInfo = getTableInformation(table);

      // System.out.println("getAggregatedTableInformation" + tableInfo.size());
      for(String colName : tableInfo.keySet())
      {
        singleTable.setCols_and_types(colName, tableInfo.get(colName));
      }

      tableObj.add(singleTable);
    }

    return tableObj;

  }
}


/* ||\
 * ---------------------------------------------------------
 */
