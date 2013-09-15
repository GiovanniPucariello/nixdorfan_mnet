/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.utilities.xml.parser.XMLParser.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

/*
* @(#)XMLParser.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.xml.parser;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.IContext;

//~--- JDK imports ------------------------------------------------------------

import java.util.HashMap;

//~--- interfaces -------------------------------------------------------------

/**
 *
 * @version        1.0, 2013.08.09
 * @author         bas
 */
public interface XMLParser
{
  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param iContext Context
   */
  public void setContext(IContext iContext);

  /**
   */
  public void setParser();

  /**
   *
   * @param xmldata String
   *
   * @return HashMap<String,Object>
   */
  public HashMap< String, Object > parseXML(String xmldata);
}


/* ||\
 * ---------------------------------------------------------
 */
