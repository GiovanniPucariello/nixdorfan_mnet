/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.verbindungsraum.gsal.models.GSALTreeModel.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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
