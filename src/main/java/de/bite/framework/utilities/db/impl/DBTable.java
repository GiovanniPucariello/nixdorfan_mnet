/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bite.framework.utilities.db.impl;

import de.bite.framework.utilities.db.IDBTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

/**
 *
 * @author nixdorfan
 */
public class DBTable implements IDBTable, Comparable {
    
    private String tablename;
    private ArrayList<String> columns = new ArrayList<String>();
    private HashMap<String,String> cols_and_types = new HashMap<String,String>();

    @Override
    public String getTablename() {
        return tablename;
    }

    @Override
    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    @Override
    public ArrayList<String> getColumns() {
        return columns;
    }

    @Override
    public void setColumns(String columns) {
        this.columns.add(columns);
    }

    @Override
    public HashMap<String, String> getCols_and_types() {
        return cols_and_types;
    }

    @Override
    public void setCols_and_types(String cols, String types) {
        this.cols_and_types.put(cols, types);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    
    
    
    
}
