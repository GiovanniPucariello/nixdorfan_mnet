/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.service.batch.exporter.PropertiesExporter.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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
