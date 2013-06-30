/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bite.framework.context.impl;

import java.util.Iterator;
import java.util.Set;

import de.bite.framework.constants.Constants;
import de.bite.framework.context.extension.impl.ContextExtension;
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
    
    /**
    *
    * @param propertyName String
    *
    * @return Object[]
    */
   @Override
   public Object[] getObjectHistory(String propertyName)
   {
     this.getLogger().info(Constants.impl_message + " getObjectHistory(String propertyName)");

     return null;
   }

   /**
    *
    * @return Object[]
    */
   @Override
   public Object[] getObjectHistory()
   {

     Set      allObjectKeys = this.contextcontainer.keySet();
     Object[] cextHistory   = null;

     this.getLogger().info("                               ");
     this.getLogger().info("                               ");
     this.getLogger().info("                               ");
     this.getLogger().info("                               ");
     this.getLogger().info("                               ");
     this.getLogger().info("S T A T U S  AKTIVER CONTEXT :: [Anzahl enthaltener Objekte] :: " + allObjectKeys.size());
     this.getLogger().info("                               | ");
     this.getLogger().info("                               | ");
     this.getLogger().info("                               | ");
     this.getLogger().info("                               | ");
     this.getLogger().info("                               | ");
     this.getLogger().info("                               | ");

     Iterator iter = allObjectKeys.iterator();

     while(iter.hasNext())
     {
       String           key  = (String)iter.next();
       ContextExtension cext = (ContextExtension)this.contextcontainer.get(key);

       this.getLogger().info("Object :: [NAME] :: " + key + " ---- " + cext);
       this.getLogger().info("                               | ");

       cextHistory = cext.getObjectHistory();

       for(int i = 0; i < cextHistory.length; i++)
       {
         this.getLogger().info("                               | ");
         this.getLogger().info("                               |----- " + cextHistory[i]);
         this.getLogger().info("                               | ");
         this.getLogger().info("                               | ");
         this.getLogger().info("                               | ");
       }
     }

     this.getLogger().info("                               | ");
     this.getLogger().info("                               |----------- EOF CONTEXT ");

     // logger.info( Constants.impl_message + " getObjectHistory()"  );
     return cextHistory;

   }
    
}
