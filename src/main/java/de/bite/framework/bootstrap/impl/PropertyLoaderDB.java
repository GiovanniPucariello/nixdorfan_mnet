/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bite.framework.bootstrap.impl;

import de.bite.framework.bootstrap.IPropertyLoader;
import de.bite.framework.factories.impl.DefaultFactory;
import de.bite.framework.service.batch.exporter.*;
import de.bite.framework.utilities.db.Datenbank;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author nixdorfan
 */
public class PropertyLoaderDB implements IPropertyLoader{

    @Override
    public Properties[] loadProperties(String pathOrFile) throws Exception {
        
        DefaultFactory factory = new DefaultFactory();
        
        String[] pathToDBKonfigs = pathOrFile.split("@@@");
        Datenbank datenbank = (Datenbank)factory.getObject(pathToDBKonfigs[1]);
        
        String dbPropertyPath = pathToDBKonfigs[0];
        Properties dbproperties = new Properties();
        dbproperties.load(new FileInputStream(dbPropertyPath));
        
        datenbank.setKonfig(dbproperties);
        PropertiesExporter exporter = new PropertiesExporter(datenbank);
        return exporter.export();
    }

    // werden in dieser Klasse nicht gebraucht
    @Override
    public void isInputStringValid(String pathOrFile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isInputStringDirectory(String pathOrFile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void checkSingleFileAsPropertyFile(String pathToProperty) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<String> extractAndAnalyzePropertiesFromDirectory(ArrayList<?> filesToLoad) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
