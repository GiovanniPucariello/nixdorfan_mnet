/**
 *
 * Copyright (c) 2012.03.08
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_01-b08
 * 
 */

package de.bite.framework.utilities.xml.parser;

//~--- interfaces -------------------------------------------------------------

public interface IndividualXMLParser extends XMLParser
{
  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param context_member_name String
   */
  public void setParser(String context_member_name);
}


/* ||\
 * ---------------------------------------------------------
 */
