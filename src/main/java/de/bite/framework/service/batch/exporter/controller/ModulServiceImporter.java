package de.bite.framework.service.batch.exporter.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import de.bite.framework.controller.impl.AbstractController;
import de.bite.framework.service.batch.importer.PropertiesImporter;

public class ModulServiceImporter extends AbstractController {

	@Override
	public void dispatch() {
		
		// Properties
	    Properties dbproperties = new Properties();
	    PropertiesImporter importer = new PropertiesImporter();
	    
	    try {
			dbproperties.load(new FileInputStream(this.iContext.getStringValueFromProperties("service.db")));
		    importer.load(this.iContext.getStringValueFromProperties("service.directorypath"));
		    importer.cleanAndBuildDataBase(dbproperties, this.iContext);
		    importer.importProperties(dbproperties,this.iContext);
		} catch (FileNotFoundException ex) {
			this.iContext.getLogger().error("FileNotFoundException" + ex.getLocalizedMessage());
			ex.printStackTrace();
		} catch (IOException ex) {
			this.iContext.getLogger().error("IOException" + ex.getLocalizedMessage());
			ex.printStackTrace();
		} catch (Exception ex){
			this.iContext.getLogger().error("Exception" + ex.getLocalizedMessage());
			ex.printStackTrace();
		}
	}

	@Override
	public boolean isSuccessful() {
		return true;
	}

	@Override
	public String actualControllerState() {
		return null;
	}

}
