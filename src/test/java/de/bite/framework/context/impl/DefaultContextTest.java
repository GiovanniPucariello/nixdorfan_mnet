
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package de.bite.framework.context.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.bootstrap.impl.Bootstrap;
import de.bite.framework.bootstrap.impl.ConsoleValuesPreparator;
import de.bite.framework.context.IContext;
import de.bite.framework.context.extension.impl.ContextStatus;
import de.bite.framework.context.extension.impl.ContextType;
import junit.framework.TestCase;

/**
 *
 * @author nixdorfan
 */
public class DefaultContextTest extends TestCase {
    
    String[] ary = new String[6];
    IContext context;
    
    public DefaultContextTest() {
        //ary[0] = "path=/home/nixdorfan/NetBeansProjects/nixdorfan_mnet/src/main/resources"; 
        //ary[1] = "dbkonfig=/home/nixdorfan/NetBeansProjects/nixdorfan_mnet/src/main/resources/db"; 
        ary[0] = "path=C:/Users/AN/Documents/NetBeansProjects/nixdorfan_mnet/src/main/resources"; 
        ary[1] = "dbkonfig=C:/Users/AN/Documents/NetBeansProjects/nixdorfan_mnet/src/main/resources/db"; 
        //ary[0] = "path=C:/Project/gsal/conf"; 
        //ary[1] = "dbkonfig=C:/Project/gsal/conf/db"; 
        ary[2] = "useGUI=false";
        ary[3] = "propertyloader=de.bite.framework.bootstrap.impl.PropertyLoader";      
        ary[4] = "resource=path"; 
        ary[5] = "dbreflection=de.bite.framework.utilities.db.impl.DatenbankObj";

        this.context  = Bootstrap.startContext(ConsoleValuesPreparator.prepare(ary));
    }

    public void testxtContConversation(){
        
        String string1 = "String1";
        String string2 = "String2";
        String string3= "String3";
        
        this.context.setObject(ContextStatus.CONVERSATION_AKTIV, string1, "string", "no1");
        this.context.setObject(ContextStatus.CONVERSATION_AKTIV, string2, "string", "no2");
        this.context.setObject(ContextStatus.CONVERSATION_AKTIV, string3, "string", "no3");
        
        String resultString = (String)this.context.getObject("string", ContextType.NEW, "no2");
        //System.out.println(" TEST == "  + resultString);
        assertEquals("String2",resultString);
        
        String resultString2 = (String)this.context.getObject("string", ContextType.NEW, "no1");
        //System.out.println(" TEST2 == "  + resultString2);
        assertEquals("String1",resultString2);
        
    }
}
