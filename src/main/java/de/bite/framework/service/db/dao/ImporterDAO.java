/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bite.framework.service.db.dao;

import de.bite.framework.context.IContext;
import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.utilities.db.Datenbank;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author nixdorfan
 */
public class ImporterDAO {
   
    private IContext context;
    private Datenbank datenbank;
 
    public ImporterDAO(Properties db, IContext context){
        this.context = context;
        this.datenbank = (Datenbank)context.getObject("default.datenbank", ContextType.NEW, null);
        datenbank.setKonfig(db);
    }
    
    // welche AppliKationen gibt es
    public boolean insertPropertyName(String name){

        String sql = "insert into applications (aid,name,app_id) values (" + this.context.getStringValueFromProperties("service.db.sequence.nameid") +",'" 
                + name + "',"+this.context.getStringValueFromProperties("service.db.sequence.nameappid") + ")";
        
        int result = this.datenbank.execDMLStmt(sql);
        
        if(result == 0){
            this.context.getLogger().error(sql);
            return false;
        } else {
            this.context.getLogger().info("Datensatz eingetragen");
            return true;
        }
    }
    
    // welche Werte haben diese Applikationen?
    public boolean insertPropertyKeyValue(String key, String value, String name){
        
        String sql = "insert into applications_key_value (akvid,app_key,app_value,name,fk_app_id) values (" + this.context.getStringValueFromProperties("service.db.sequence.keyvalue") 
        +",'" + key + "',"+"'" + value + "',"+"'"+ name + "',(select app_id from applications where name ='" + name +"'" + ") )";
        
        int result = this.datenbank.execDMLStmt(sql);
        
        if(result == 0){
            this.context.getLogger().error(sql);
            return false;
        } else {
            this.context.getLogger().info("Datensatz eingetragen");
            return true;
        }
    }
    
    // Bereinige Datenbanken
    public boolean clean(String cleanSQL){
        int result = this.datenbank.execDMLStmt(cleanSQL);
        
        if(result == 0){
            this.context.getLogger().error(cleanSQL);
            return false;
        } else {
            this.context.getLogger().info("Datenbank bereinigt");
            return true;
        }
    }
    
   
    public void closeImporter(){
        this.datenbank.closeStatementAndConnection();
    }

}
