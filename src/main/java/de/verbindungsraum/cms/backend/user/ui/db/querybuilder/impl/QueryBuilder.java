/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.verbindungsraum.cms.backend.user.ui.db.querybuilder.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.context.IContext;
import de.bite.framework.utilities.db.Datenbank;

import de.verbindungsraum.cms.backend.user.ui.db.querybuilder.IQueryBuilder;

//~--- JDK imports ------------------------------------------------------------

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.HashMap;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class QueryBuilder implements IQueryBuilder
{

  //~--- fields ---------------------------------------------------------------

  private IContext context;

  //~--- methods --------------------------------------------------------------

  /**
   * 
   * @param SQL String
   *
   * @return HashMap<String,String>
   */
  @Override
  public HashMap< String, String > getResult(String SQL)
  {

    HashMap< String, String > tableColInfo = new HashMap< String, String >();
    Datenbank                 db           = (Datenbank)this.context.getObject("cms.datenbank", ContextType.USED, null);

    if((SQL.toLowerCase()).indexOf("insert") == -1 && (SQL.toLowerCase()).indexOf("update") == -1 && (SQL.toLowerCase()).indexOf("delete") == -1 && (SQL.toLowerCase()).indexOf("select") != -1)
    {
      ResultSet rs = db.execStmt(SQL);

      tableColInfo.put("cms.datenbank.query", SQL);

      try
      {
        ResultSetMetaData rsmd = rs.getMetaData();
        int               cols = rsmd.getColumnCount();

        tableColInfo.put("ResultSet-Columncount", cols + "");

        for(int i = 1; i <= cols; i++)
        {
          tableColInfo.put(i + "", rsmd.getColumnLabel(i));
        }

        while(rs.next())
        {
          for(int i = 1; i <= cols; i++)
          {
            tableColInfo.put(rs.getObject(i) + "", rs.getObject(i) + "");
          }
        }

        return tableColInfo;
      }
      catch(SQLException ex)
      {
        ex.printStackTrace();

        return new HashMap< String, String >();
      }
    }
    else
    {
      int    result       = db.execDMLStmt(SQL);
      String resultString = "";

      if(result == 1)
      {
        resultString = "success";
      }
      else
      {
        resultString = "failure";
      }

      tableColInfo.put("cms.datenbank.query", SQL);
      tableColInfo.put("cms.datenbank.query.result", resultString);

      return tableColInfo;
    }

  }

  /**
   * 
   * @param context IContext
   */
  @Override
  public void setContext(IContext context)
  {
    this.context = context;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
