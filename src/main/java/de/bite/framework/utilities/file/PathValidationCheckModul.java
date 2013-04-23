package de.bite.framework.utilities.file;

import de.bite.framework.context.IContext;

public abstract class PathValidationCheckModul {

	public IContext context;
	
	public void setContext(IContext context){
		this.context = context;
	}
	
	public abstract boolean isValidPath(String path);
	
	public abstract String getVerifcatedPath(String path);
	
	public abstract boolean isFile(String path);
	
	public abstract boolean isRequestForPath(String key);

}
