/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.verbindungsraum.cms.backend.user.ui.db.info;

import de.bite.framework.constants.Constants;
import de.bite.framework.context.IContext;
import de.bite.framework.utilities.db.Datenbank;
import de.bite.framework.utilities.db.IDBTable;
import de.bite.framework.utilities.system.SystemInformation;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author nixdorfan
 */
public class DBInfoTreeBuilder {
    
   
    private IContext context;
    private Datenbank datenbank;
    private DefaultMutableTreeNode root = new DefaultMutableTreeNode(); 
    
    public void setContext(IContext context){
        this.context = context;
    }
    
    public void setDatenbank(Datenbank datenbank){
        this.datenbank = datenbank;
    }
    
    public DefaultMutableTreeNode getTreeItems(){
        ArrayList<IDBTable> allTables = this.datenbank.getAggregatedTableInformation(this.context);
        createTree(root,allTables);
        return root;
    }
    
    public void createTree(DefaultMutableTreeNode node, ArrayList<IDBTable> allTables){
        for(IDBTable singleTable : allTables){
            
            DefaultMutableTreeNode tableNode = new DefaultMutableTreeNode( singleTable.getTablename() );
            HashMap<String,String> tableDetail = singleTable.getCols_and_types();
            
            for (String colName: tableDetail.keySet()){
                DefaultMutableTreeNode tableDetailNodeName = new DefaultMutableTreeNode( colName );            
                DefaultMutableTreeNode tableDetailNodeType = new DefaultMutableTreeNode( tableDetail.get(colName) );
                tableDetailNodeName.add(tableDetailNodeType);
                tableNode.add(tableDetailNodeName);
                
            }
            
            node.add(tableNode);
            
        }
    }
}
