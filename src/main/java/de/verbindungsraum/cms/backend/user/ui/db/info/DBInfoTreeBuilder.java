/**
 *
 * Copyright (c) 2013.06.14
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0-b147
 * 
 */

package de.verbindungsraum.cms.backend.user.ui.db.info;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.constants.Constants;
import de.bite.framework.context.IContext;
import de.bite.framework.utilities.db.Datenbank;
import de.bite.framework.utilities.db.IDBTable;
import de.bite.framework.utilities.system.SystemInformation;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import javax.swing.tree.DefaultMutableTreeNode;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class DBInfoTreeBuilder
{

  //~--- fields ---------------------------------------------------------------

  private IContext               context;
  private Datenbank              datenbank;
  private DefaultMutableTreeNode root = new DefaultMutableTreeNode();

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param context IContext
   */
  public void setContext(IContext context)
  {
    this.context = context;
  }

  /**
   *
   * @param datenbank Datenbank
   */
  public void setDatenbank(Datenbank datenbank)
  {
    this.datenbank = datenbank;
  }

  /**
   *
   * @return DefaultMutableTreeNode
   */
  public DefaultMutableTreeNode getTreeItems()
  {
    ArrayList< IDBTable > allTables = this.datenbank.getAggregatedTableInformation(this.context);

    createTree(root, allTables);

    return root;
  }

  /**
   *
   * @param node DefaultMutableTreeNode
   * @param allTables ArrayList<IDBTable>
   */
  public void createTree(DefaultMutableTreeNode node, ArrayList< IDBTable > allTables)
  {
    for(IDBTable singleTable : allTables)
    {
      DefaultMutableTreeNode    tableNode   = new DefaultMutableTreeNode(singleTable.getTablename());
      HashMap< String, String > tableDetail = singleTable.getCols_and_types();

      for(String colName : tableDetail.keySet())
      {
        DefaultMutableTreeNode tableDetailNodeName = new DefaultMutableTreeNode(colName);
        DefaultMutableTreeNode tableDetailNodeType = new DefaultMutableTreeNode(tableDetail.get(colName));

        tableDetailNodeName.add(tableDetailNodeType);
        tableNode.add(tableDetailNodeName);
      }

      node.add(tableNode);
    }
  }
}


/* ||\
 * ---------------------------------------------------------
 */
