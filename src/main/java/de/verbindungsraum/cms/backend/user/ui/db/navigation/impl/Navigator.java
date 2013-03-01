/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.verbindungsraum.cms.backend.user.ui.db.navigation.impl;

import de.bite.framework.context.IContext;
import de.bite.framework.context.extension.impl.ContextStatus;
import de.bite.framework.context.extension.impl.ContextType;
import de.verbindungsraum.cms.backend.user.ui.db.navigation.INavigator;
import java.util.LinkedList;

/**
 *
 * @author nixdorfan
 */
public class Navigator implements INavigator {
    
    private IContext context;
    private LinkedList<String> forward = new LinkedList<String>();
    private LinkedList<String> backward = new LinkedList<String>();
    private String actual;
    
    @Override
    public void setContext( IContext context){
        this.context = context;
    }
    
    @Override
    public String getActualNavigationPoint(){
        return actual;
    }
    
    @Override
    public void setActualNavigationPoint(String actualSQL){
       if(this.actual != null){
           backward.add(this.actual);
           this.actual = actualSQL;
       } else {
           this.actual = actualSQL;
       }
    }

    @Override
    public String getBackwardNavigationPoint() {
        if(backward.isEmpty()){
            return "Cache leer";
        } else{
            String last = backward.pollLast();
            forward.add(last);
            return last;
        }
    }

    @Override
    public String getForwardNavigationPoint() {
        if(forward.isEmpty()){
            return "noch kein Cache aufgebaut";
        } else {
            String next = forward.pollLast();
            backward.add(next);
            return next;
        }
    }
}
