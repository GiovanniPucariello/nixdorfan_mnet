/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.verbindungsraum.gsal.models;

//~--- JDK imports ------------------------------------------------------------

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class GSALTreeModel extends DefaultTreeModel
{
  //~--- constructors ---------------------------------------------------------

  /**
   *
   * @param treenode TreeNode
   */
  public GSALTreeModel(TreeNode treenode)
  {
    super(treenode);
  }




  /**
   *
   * @param treenode TreeNode
   * @param isVisible boolean
   */
  public GSALTreeModel(TreeNode treenode, boolean isVisible)
  {
    super(treenode, isVisible);
  }
}


/* ||\
 * ---------------------------------------------------------
 */
