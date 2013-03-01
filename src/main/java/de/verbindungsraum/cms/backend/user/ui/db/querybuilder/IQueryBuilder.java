/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.verbindungsraum.cms.backend.user.ui.db.querybuilder;

import de.bite.framework.context.IContext;
import java.util.HashMap;

/**
 *
 * @author nixdorfan
 */
public interface IQueryBuilder {
    
    public void setContext(IContext context);
    
    public HashMap<String,String> getResult(String SQL);
}
