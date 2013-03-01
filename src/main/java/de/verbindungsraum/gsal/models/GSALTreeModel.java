/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.verbindungsraum.gsal.models;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author nixdorfan
 */
public class GSALTreeModel  extends DefaultTreeModel {
    
       public GSALTreeModel(TreeNode treenode){
        super( treenode );
    }
    
    public GSALTreeModel(TreeNode treenode, boolean isVisible){
        super( treenode, isVisible );
    }
}
