/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.context.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.bootstrap.impl.Bootstrap;
import de.bite.framework.bootstrap.impl.ConsoleValuesPreparator;
import de.bite.framework.context.extension.impl.ContextStatus;
import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.context.IContext;

import junit.framework.TestCase;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class DefaultContextTest extends TestCase
{
  //~--- fields ---------------------------------------------------------------

  String[] ary = new String[6];
  IContext context;

  //~--- constructors ---------------------------------------------------------

  /**
   */
  public DefaultContextTest()
  {

    ary[0] = "path=/home/nixdorfan/NetBeansProjects/nixdorfan_mnet/src/main/resources";
    ary[1] = "dbkonfig=/home/nixdorfan/NetBeansProjects/nixdorfan_mnet/src/main/resources/db";
     //ary[0] = "path=C:/Users/AN/Documents/NetBeansProjects/nixdorfan_mnet/src/main/resources";
     //ary[1] = "dbkonfig=C:/Users/AN/Documents/NetBeansProjects/nixdorfan_mnet/src/main/resources/db";
      //ary[0] = "path=C:/Project/nixdorfan_dyndns/NetBeansProjects/nixdorfan_mnet/src/main/resources";
      //ary[1] = "dbkonfig=C:/Project/nixdorfan_dyndns/NetBeansProjects/nixdorfan_mnet/src/main/resources/db";
	//ary[0]= "path=C:/Project/bite.framework.mnet/src/main/resources";
	//ary[1]= "dbkonfig=C:/Project/bite.framework.mnet/src/main/resources/db";
//    ary[0]       = "path=C:/Project/gsal/conf";
//    ary[1]       = "dbkonfig=C:/Project/gsal/conf/db";
    ary[2]       = "useGUI=false";
    ary[3]       = "propertyloader=de.bite.framework.bootstrap.impl.PropertyLoader";
    ary[4]       = "resource=path";
    ary[5]       = "dbreflection=de.bite.framework.utilities.db.impl.DatenbankObj";
    this.context = Bootstrap.startContext(ConsoleValuesPreparator.prepare(ary));
  }




  //~--- methods --------------------------------------------------------------

  /**
   */
  public void testxtContConversation()
  {
    String string1 = "String1";
    String string2 = "String2";
    String string3 = "String3";

    this.context.setObject(ContextStatus.CONVERSATION_AKTIV, string1, "string", "no1");
    this.context.setObject(ContextStatus.CONVERSATION_AKTIV, string2, "string", "no2");
    this.context.setObject(ContextStatus.CONVERSATION_AKTIV, string3, "string", "no3");

    String resultString = (String)this.context.getObject("string", ContextType.NEW, "no2");

    // System.out.println(" TEST == "  + resultString);
    assertEquals("String2", resultString);

    String resultString2 = (String)this.context.getObject("string", ContextType.NEW, "no1");

    // System.out.println(" TEST2 == "  + resultString2);
    assertEquals("String1", resultString2);
  }
  
  /**
   */
  public void testContextFileDetektion()
  {
    String file = (String)this.context.getStringValueFromProperties("default.db.table.info");
    String file1 = (String)this.context.getStringValueFromProperties("default.file1");
    String file2 = (String)this.context.getStringValueFromProperties("default.file2");
    System.out.println("File 2 ==  " + file2);
    assertEquals("de.bite.framework.utilities.db.impl.DBTable",file );
    //assertEquals("C:/Project/nixdorfan_dyndns/NetbeansProjects/nixdorfan_mnet/src/main/resources/log4j.properties",file1 );
    //assertEquals("C:/Project/nixdorfan_dyndns/NetbeansProjects/nixdorfan_mnet/src/main/resources/log4j.properties",file2 );
 ;

  }
}


/* ||\
 * ---------------------------------------------------------
 */
