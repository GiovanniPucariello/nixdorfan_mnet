/**
 *
 * Copyright (c) 2013.10.04
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.utilities.xml.parser.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.constants.Constants;
import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.context.IContext;
import de.bite.framework.utilities.xml.parser.handler.XMLParserHandler;
import de.bite.framework.utilities.xml.parser.XMLParser;

import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

//~--- JDK imports ------------------------------------------------------------

/**
 *
 * Copyright (c) 2012.03.08
 * M-net Telekommunikations GmbH
 *
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_01-b08
 *
 */

/*
* @(#)DefaultParser.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
import java.io.IOException;
import java.io.Serializable;

import java.util.HashMap;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class DefaultParser implements XMLParser, Serializable
{

  //~--- fields ---------------------------------------------------------------

  public IContext         iContext;
  public XMLParserHandler xmlHandler;
  public XMLReader        xmlread;

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param iContext IContext
   *
   */
  @Override
  public void setContext(IContext iContext)
  {
    this.iContext = iContext;

    // TODO Auto-generated method stub
  }

  /**
   */
  @Override
  public void setParser()
  {
    try
    {
      this.xmlread = XMLReaderFactory.createXMLReader(this.iContext.getStringValueFromProperties("default.xmlparser"));
    }
    catch(SAXException ex)
    {
      this.iContext.getLogger().error(Constants.error_message + " SAX-Parser nicht gefunden " + ex.getLocalizedMessage());
    }

    /** Hole Parser-Handler */
    this.xmlHandler = (XMLParserHandler)this.iContext.getObject("default.xmlhandler", ContextType.NEW, null);

    /** setze Context */
    this.xmlHandler.setContext(iContext);

    /** Registriere Parser-Handler */
    this.xmlread.setContentHandler(this.xmlHandler);
  }

  /**
   *
   * @param xmldata String
   *
   * @return HashMap<String,Object>
   */
  @Override
  public HashMap< String, Object > parseXML(String xmldata)
  {

    HashMap< String, Object > data = null;

    try
    {
      this.xmlread.parse(xmldata);

      data = this.xmlHandler.getData();

      return data;
    }
    catch(IOException e)
    {
      this.iContext.getLogger().error(Constants.error_message + " " + e);

      return data;
    }
    catch(SAXException e)
    {
      this.iContext.getLogger().error(Constants.error_message + " " + e);

      return data;
    }

  }
}


/* ||\
 * ---------------------------------------------------------
 */
