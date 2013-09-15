/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.utilities.db.IDBTable.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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
