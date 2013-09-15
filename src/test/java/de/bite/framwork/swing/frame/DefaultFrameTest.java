/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framwork.swing.frame.DefaultFrameTest.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

package de.bite.framwork.swing.frame;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.bootstrap.impl.Bootstrap;
import de.bite.framework.bootstrap.impl.ConsoleValuesPreparator;
import de.bite.framework.context.extension.impl.ContextStatus;
import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.context.IContext;
import de.bite.framework.context.impl.*;
import de.bite.framework.utilities.swing.components.BiteSkeletonFrame;
import de.bite.framework.utilities.swing.components.FrameKonfigurationBuilder;

import junit.framework.TestCase;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class DefaultFrameTest extends TestCase
{

  //~--- fields ---------------------------------------------------------------

  String[] ary = new String[6];
  IContext context;

  //~--- constructors ---------------------------------------------------------

  /**
   */
  public DefaultFrameTest()
  {

//  // ary[0] = "path=/home/nixdorfan/NetBeansProjects/nixdorfan_mnet/src/main/resources";
//  // ary[1] = "dbkonfig=/home/nixdorfan/NetBeansProjects/nixdorfan_mnet/src/main/resources/db";
//  // ary[0] = "path=C:/Users/AN/Documents/NetBeansProjects/nixdorfan_mnet/src/main/resources";
//  // ary[1] = "dbkonfig=C:/Users/AN/Documents/NetBeansProjects/nixdorfan_mnet/src/main/resources/db";
//  ary[0]       = "path=C:/Project/nixdorfan_dyndns/NetBeansProjects/nixdorfan_mnet/src/main/resources";
//  ary[1]       = "dbkonfig=C:/Project/nixdorfan_dyndns/NetBeansProjects/nixdorfan_mnet/src/main/resources/db";
//
//  // ary[0]= "path=C:/Project/bite.framework.mnet/src/main/resources";
//  // ary[1]= "dbkonfig=C:/Project/bite.framework.mnet/src/main/resources/db";
////ary[0]       = "path=C:/Project/gsal/conf";
////ary[1]       = "dbkonfig=C:/Project/gsal/conf/db";
//  ary[2]       = "useGUI=false";
//  ary[3]       = "propertyloader=de.bite.framework.bootstrap.impl.PropertyLoader";
//  ary[4]       = "resource=path";
//  ary[5]       = "dbreflection=de.bite.framework.utilities.db.impl.DatenbankObj";
//  this.context = Bootstrap.startContext(ConsoleValuesPreparator.prepare(ary));
  }




  //~--- methods --------------------------------------------------------------

  /**
   */
  public void testFrameCreation()
  {

    BiteSkeletonFrame skel = new BiteSkeletonFrame(new FrameKonfigurationBuilder());

    skel.setVisible(true);

//  String string1 = "String1";
//  String string2 = "String2";
//  String string3 = "String3";
//
//  this.context.setObject(ContextStatus.CONVERSATION_AKTIV, string1, "string", "no1");
//  this.context.setObject(ContextStatus.CONVERSATION_AKTIV, string2, "string", "no2");
//  this.context.setObject(ContextStatus.CONVERSATION_AKTIV, string3, "string", "no3");
//
//  String resultString = (String)this.context.getObject("string", ContextType.NEW, "no2");
//
//  // System.out.println(" TEST == "  + resultString);
//  assertEquals("String2", resultString);
//
//  String resultString2 = (String)this.context.getObject("string", ContextType.NEW, "no1");
//
//  // System.out.println(" TEST2 == "  + resultString2);
//  assertEquals("String1", resultString2);

  }
}


/* ||\
 * ---------------------------------------------------------
 */
