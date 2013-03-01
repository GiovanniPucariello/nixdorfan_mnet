/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bite.framework.service.batch.importer;

import de.bite.framework.bootstrap.impl.PropertyLoader;
import de.bite.framework.context.IContext;
import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.service.db.dao.ImporterDAO;
import de.bite.framework.utilities.db.Datenbank;
import java.util.Enumeration;
import java.util.Properties;

/**
 *
 * @author nixdorfan
 */
public class PropertiesImporter {
    
    private Properties[] propList;
    
    public void load(String directoryPath) throws Exception{
        
        if(propList != null){
            propList = null;
        }
        
        try {
            PropertyLoader loader = new PropertyLoader();
            propList = loader.loadProperties(directoryPath);
        } catch(Exception ex){
           throw new Exception("Fehler beim Laden der Properties"); 
        }
    }
    
    
    public Boolean importProperties(Properties dbprops, IContext context){
        
        ImporterDAO importer = new ImporterDAO(dbprops,context);
        
        for(int i=0; i<propList.length;i++){
            
            Properties singleProp = propList[i];
            importer.insertPropertyName(singleProp.getProperty("name"));
            
                Enumeration<Object> enumeration =  singleProp.keys();
                
                while(enumeration.hasMoreElements()){
                    String key = (String)enumeration.nextElement();
                    String value = singleProp.getProperty(key);
                    importer.insertPropertyKeyValue(key, value, singleProp.getProperty("name"));
                
                }
            
            
        }
        importer.closeImporter();
        return true;
    }

    public void cleanAndBuildDataBase(Properties dbprops, IContext context) {
        ImporterDAO importer = new ImporterDAO(dbprops,context);
        String deleteSQL = context.getStringValueFromProperties("service.db.clean");
        importer.clean(deleteSQL);
        importer.closeImporter();
        
    }
}
