/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bite.framework.service.db.dao;

import de.bite.framework.utilities.db.Datenbank;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author nixdorfan
 */
public class ExporterDAO {
       // hole Daten aus Datenbank und generiere Properties-Dateien 
   public Properties[] getProperties(Datenbank datenbank) throws SQLException{
        
       String sqlForApps = "select name from applications";
        ResultSet resultApps = datenbank.execStmt(sqlForApps);
        ArrayList<Properties> propertyList = new ArrayList<Properties>();
        
        while(resultApps.next()){
            Properties actualProps = new Properties();
            actualProps.setProperty("name", resultApps.getString("name"));
            propertyList.add(actualProps);
        }
        
        resultApps.close();
        Properties[] returnProps = new Properties[propertyList.size()];
        
        
        int count=0;
        
        for(Properties actPro : propertyList){
            String name = actPro.getProperty("name");
            String sql = "select * from applications_key_value where name = '" + name + "'";
            System.out.println(sql);
            ResultSet actPropRes = datenbank.execStmt(sql);
            while(actPropRes.next()){
                actPro.setProperty(actPropRes.getString("app_key"), actPropRes.getString("app_value"));
            }
            actPropRes.close();
            returnProps[count] = actPro;
            count++;
        }
        return returnProps;
    }
}
