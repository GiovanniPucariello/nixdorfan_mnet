/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
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
