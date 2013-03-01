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
* @(#)IndividualParser.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.xml.parser.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.constants.Constants;
import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.utilities.xml.parser.handler.XMLParserHandler;
import de.bite.framework.utilities.xml.parser.IndividualXMLParser;

import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXException;

//~--- JDK imports ------------------------------------------------------------

import java.util.Properties;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class IndividualParser extends DefaultParser implements IndividualXMLParser
{
  //~--- methods --------------------------------------------------------------

  /**
   * 
   * @param context_member_name String
   */
  @Override
  public void setParser(String mod_properties)
  {

    try{
        this.xmlread      = XMLReaderFactory.createXMLReader( this.iContext.getStringValueFromProperties(mod_properties +".xmlparser"));
    } catch (SAXException ex){
        this.iContext.getLogger().error(Constants.error_message + " SAX-Parser nicht gefunden " + ex.getLocalizedMessage());
    }

    /** Hole Parser-Handler */
    this.xmlHandler = (XMLParserHandler)this.iContext.getObject(mod_properties + ".xmlhandler", ContextType.NEW,null);

    /** setze Context */
    this.xmlHandler.setContext(iContext);

    /** Registriere Parser-Handler */
    this.xmlread.setContentHandler(this.xmlHandler);
  }
}


/* ||\
 * ---------------------------------------------------------
 */