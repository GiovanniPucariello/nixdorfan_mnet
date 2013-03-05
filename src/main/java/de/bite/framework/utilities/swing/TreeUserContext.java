/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bite.framework.utilities.swing;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author nixdorfan
 */
public class TreeUserContext {
    
    HashMap<String,TreeUserObject> treeusers = new  HashMap<String,TreeUserObject>();
    
    public void setTreeUserObject( String name, TreeUserObject treeuser ){
        this.treeusers.put(name, treeuser);
    }
    
    public TreeUserObject getTreeUserObject( String name ){
        return (TreeUserObject)this.treeusers.get(name);
    }
    
    public Collection<TreeUserObject> getAllTreeUserObjects(){
        return this.treeusers.values();
    }
}
