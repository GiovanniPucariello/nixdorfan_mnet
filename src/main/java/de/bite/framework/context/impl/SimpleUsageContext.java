/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bite.framework.context.impl;

import de.bite.framework.context.extension.impl.ContextStatus;
import de.bite.framework.context.extension.impl.ContextType;

/**
 *
 * @author nixdorfan
 */
public class SimpleUsageContext extends AbstractContext {

    @Override
    public Object getObject(String clazzname){
        return super.getObject(clazzname, ContextType.NEW, null);
    }
    
    @Override
    public void setObject(String objectname, Object object){
        super.setObject(ContextStatus.AKTIV, object, objectname, null);
    }
    
    @Override
    public Object getConversationObject(String clazzname, String conversationFlowState){
        return super.getObject(clazzname, ContextType.NEW, conversationFlowState);
    }
    
    @Override
    public void setConversationObject(String objectname, String conversationFlowState, Object object){
        super.setObject(ContextStatus.AKTIV, object, objectname, conversationFlowState);
    }
    
    @Override
    public Object[] getObjectHistory(String propertyName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object[] getObjectHistory() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
