/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.service.batch.exporter;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.IContext;
import de.bite.framework.service.db.dao.ExporterDAO;
import de.bite.framework.service.db.dao.ImporterDAO;
import de.bite.framework.utilities.db.Datenbank;

//~--- JDK imports ------------------------------------------------------------

import java.io.FileInputStream;

import java.util.Properties;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class PropertiesExporter
{
  //~--- fields ---------------------------------------------------------------

  private Datenbank datenbank;
  private String    dbkonfigurations;

  //~--- constructors ---------------------------------------------------------

  /**
   *
   * @param datenbank Datenbank
   */
  public PropertiesExporter(Datenbank datenbank)
  {
    this.datenbank = datenbank;
  }




  //~--- methods --------------------------------------------------------------

  /**
   *
   * @return Properties[]
   *
   * @throws Exception
   */
  public Properties[] export() throws Exception
  {

    // Properties
    ExporterDAO  exporter = new ExporterDAO();
    Properties[] list     = exporter.getProperties(this.datenbank);

    return list;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
