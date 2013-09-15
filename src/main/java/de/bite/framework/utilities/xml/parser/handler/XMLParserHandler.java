/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.utilities.xml.parser.handler.XMLParserHandler.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

/*
* @(#)XMLParserHandler.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.xml.parser.handler;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.IContext;

import org.xml.sax.Attributes;

//~--- JDK imports ------------------------------------------------------------

import java.util.HashMap;

//~--- interfaces -------------------------------------------------------------

/**
 *
 * @version        1.0, 2013.08.09
 * @author         bas
 */
public interface XMLParserHandler extends org.xml.sax.ContentHandler
{
  //~--- methods --------------------------------------------------------------

  /**
   */
  @Override
  public void startDocument();

  /**
   */
  @Override
  public void endDocument();

  /**
   *
   * @param namespaceURI String
   * @param localName String
   * @param qName String
   * @param attrs Attributes
   */
  @Override
  public void startElement(String namespaceURI, String localName, String qName, Attributes attrs);

  /**
   *
   * @param buf char[]
   * @param offset int
   * @param len int
   */
  @Override
  public void characters(char[] buf, int offset, int len);

  /**
   *
   * @param xmlvalue String
   *
   * @return String
   */
  public String checkValueStringFromXML(String xmlvalue);

  /**
   *
   * @return HashMap<String,Object>
   */
  public HashMap< String, Object > getData();

  /**
   *
   * @param iContext Context
   */
  public void setContext(IContext iContext);
}


/* ||\
 * ---------------------------------------------------------
 */
