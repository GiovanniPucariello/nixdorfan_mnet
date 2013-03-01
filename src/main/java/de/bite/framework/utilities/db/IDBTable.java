/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bite.framework.utilities.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

/**
 *
 * @author AN
 */
public interface IDBTable {

    HashMap<String, String> getCols_and_types();

    ArrayList<String> getColumns();

    String getTablename();

    void setCols_and_types(String cols, String types);

    void setColumns(String columns);

    void setTablename(String tablename);
    
}
