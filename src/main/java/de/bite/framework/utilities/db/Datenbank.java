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
* @(#)Datenbank.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.db;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.IContext;

//~--- JDK imports ------------------------------------------------------------

import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.TreeSet;

//~--- interfaces -------------------------------------------------------------

public interface Datenbank
{

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param dbprops Properties
   *
   * @return boolean
   */
  public abstract boolean setKonfig(Properties dbprops);

  /**
   */
  public abstract void setStatement();

  /**
   */
  public abstract void closeStatementAndConnection();

  /**
   */
  public abstract void setObjdb();

  /**
   *
   * @return Statement
   */
  public abstract Statement getStatement();

  /**
   *
   * @param query String
   *
   * @return ResultSet
   */
  public abstract ResultSet execStmt(String query);

  /**
   *
   * @param query String
   *
   * @return int
   */
  public abstract int execDMLStmt(String query);

  /**
   *
   * @param newprops Properties
   */
  public abstract void setProps(Properties newprops);

  /**
   *
   * @return Properties
   */
  public abstract Properties getProps();

  /**
   */
  public abstract void setNewStatement();

  /**
   *
   * @return HashMap<String,String>
   */
  public abstract HashMap< String, String > getDBMetaData();

  /**
   * 
   * @param tablename String
   *
   * @return HashMap<String,String>
   */
  public abstract HashMap< String, String > getTableInformation(String tablename);

  /**
   *
   * @return HashMap<String,String>
   */
  public HashMap< String, String > getTables();

  /**
   * 
   * @param context IContext
   *
   * @return ArrayList<IDBTable>
   */
  public ArrayList< IDBTable > getAggregatedTableInformation(IContext context);
}


/* ||\
 * ---------------------------------------------------------
 */
