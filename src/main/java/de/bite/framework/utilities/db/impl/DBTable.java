/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.utilities.db.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.utilities.db.IDBTable;

//~--- JDK imports ------------------------------------------------------------

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class DBTable implements IDBTable, Comparable
{

  //~--- fields ---------------------------------------------------------------

  private String                    tablename;
  private ArrayList< String >       columns        = new ArrayList< String >();
  private HashMap< String, String > cols_and_types = new HashMap< String, String >();

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @return String
   */
  @Override
  public String getTablename()
  {
    return tablename;
  }

  /**
   * 
   * @param tablename String
   */
  @Override
  public void setTablename(String tablename)
  {
    this.tablename = tablename;
  }

  /**
   *
   * @return ArrayList<String>
   */
  @Override
  public ArrayList< String > getColumns()
  {
    return columns;
  }

  /**
   * 
   * @param columns String
   */
  @Override
  public void setColumns(String columns)
  {
    this.columns.add(columns);
  }

  /**
   *
   * @return HashMap<String,String>
   */
  @Override
  public HashMap< String, String > getCols_and_types()
  {
    return cols_and_types;
  }

  /**
   * 
   * @param cols String
   * @param types String
   */
  @Override
  public void setCols_and_types(String cols, String types)
  {
    this.cols_and_types.put(cols, types);
  }

  /**
   * 
   * @param o Object
   *
   * @return int
   */
  @Override
  public int compareTo(Object o)
  {
    return 0;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
