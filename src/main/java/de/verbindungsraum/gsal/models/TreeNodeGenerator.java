/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.verbindungsraum.gsal.models;

import de.bite.framework.context.IContext;
import de.bite.framework.utilities.system.SystemInformation;
import de.bite.framework.constants.Constants;
import java.io.File;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import org.apache.log4j.Logger;

/**
 *
 * @author nixdorfan
 */
public class TreeNodeGenerator {
    
    private DefaultMutableTreeNode rooter = new DefaultMutableTreeNode(); 
    private IContext context = null;
    private Logger logger = Logger.getLogger(TreeNodeGenerator.class);
    
    public TreeNodeGenerator( IContext context ){
        this.context = context;
    }
    
    public String getSelectionPath(TreePath treePath){
        return null;
    }
    
    public String getSelectedFileOrDirectory(TreePath treePath){
        return null;
    }
    
    public MutableTreeNode getRootNode(String path){
        this.createTree(this.rooter, path);
        return this.rooter;
    }     
    
    private void createTree(DefaultMutableTreeNode node, String path){
         try{
             
            File f = new File(path);
            File arr[]= f.listFiles();

            for(int i = 0; i< arr.length; i++){
                if(arr[i].isFile()){
                    String aryFileName = arr[i].getPath();
                    String fileName = aryFileName.substring( aryFileName.lastIndexOf( SystemInformation.getFileSeparator() ) +1  );
                    DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode( fileName );
                    this.context.getLogger().info(Constants.info_message + " FileNode == " + fileName);
                    node.add(tempNode);
                } else {
                    String aryDirName = arr[i].getPath();
                    String dirName = aryDirName.substring( aryDirName.lastIndexOf( SystemInformation.getFileSeparator() ) +1  );
                    DefaultMutableTreeNode tempDirNode = new DefaultMutableTreeNode( dirName );
                    this.context.getLogger().info(Constants.info_message + " DirNode == " + dirName);
                    node.add( tempDirNode );
                    this.createTree( tempDirNode, aryDirName );
                }
             } 
             
       } catch(Exception ex) {
           this.context.getLogger().error(Constants.error_message + " " + ex);
           ex.printStackTrace();
       }
    }
}
