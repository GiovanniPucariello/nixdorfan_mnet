/**
 *
 * Copyright (c) 2013.06.14
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0-b147
 * 
 */

package de.bite.framework.utilities.db;

//~--- JDK imports ------------------------------------------------------------

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

//~--- interfaces -------------------------------------------------------------

/**
 *
 * @author AN
 */
public interface IDBTable
{
  //~--- methods --------------------------------------------------------------

  /**
   *
   * @return HashMap<String,String>
   */
  HashMap< String, String > getCols_and_types();

  /**
   *
   * @return ArrayList<String>
   */
  ArrayList< String > getColumns();

  /**
   *
   * @return String
   */
  String getTablename();

  /**
   *
   * @param cols String
   * @param types String
   */
  void setCols_and_types(String cols, String types);

  /**
   *
   * @param columns String
   */
  void setColumns(String columns);

  /**
   *
   * @param tablename String
   */
  void setTablename(String tablename);
}


/* ||\
 * ---------------------------------------------------------
 */
