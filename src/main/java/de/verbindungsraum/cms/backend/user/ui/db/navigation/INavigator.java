/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.verbindungsraum.cms.backend.user.ui.db.navigation;

import de.bite.framework.context.IContext;

/**
 *
 * @author nixdorfan
 */
public interface INavigator {

    String getActualNavigationPoint();
    
    String getBackwardNavigationPoint();
    
    String getForwardNavigationPoint();

    void setActualNavigationPoint(String actualSQL);

    void setContext(IContext context);
    
}
