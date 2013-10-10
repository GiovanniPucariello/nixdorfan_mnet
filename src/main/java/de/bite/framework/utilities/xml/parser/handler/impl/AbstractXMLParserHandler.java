/**
 *
 * Copyright (c) 2013.10.04
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

/*
* @(#)AbstractXMLParserHandler.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.xml.parser.handler.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.constants.Constants;
import de.bite.framework.context.IContext;
import de.bite.framework.utilities.xml.parser.handler.XMLParserHandler;

import org.apache.log4j.Logger;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

//~--- JDK imports ------------------------------------------------------------

import java.io.Serializable;

import java.util.HashMap;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public abstract class AbstractXMLParserHandler implements XMLParserHandler, Serializable
{

  //~--- fields ---------------------------------------------------------------

  public Logger   logger = Logger.getLogger(AbstractXMLParserHandler.class);
  public IContext iContext;

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param iContext Context
   */
  @Override
  public void setContext(IContext iContext)
  {
    this.iContext = iContext;

    logger.info(Constants.info_message + " Context gesetzt :: " + iContext.toString());
  }

  /**
   *
   * @param arg0 String
   * @param arg1 String
   * @param arg2 String
   *
   * @throws SAXException
   */
  @Override
  public abstract void endElement(String arg0, String arg1, String arg2) throws SAXException;

  /**
   */
  @Override
  public abstract void startDocument();

  /**
   */
  @Override
  public abstract void endDocument();

  /**
   *
   * @param namespaceURI String
   * @param localName String
   * @param qName String
   * @param attrs Attributes
   */
  @Override
  public abstract void startElement(String namespaceURI, String localName, String qName, Attributes attrs);

  /**
   *
   * @param buf char[]
   * @param offset int
   * @param len int
   */
  @Override
  public abstract void characters(char[] buf, int offset, int len);

  /**
   *
   * @param xmlvalue String
   *
   * @return String
   */
  @Override
  public abstract String checkValueStringFromXML(String xmlvalue);

  /**
   *
   * @return HashMap<String,Object>
   */
  @Override
  public abstract HashMap< String, Object > getData();
}


/* ||\
 * ---------------------------------------------------------
 */
