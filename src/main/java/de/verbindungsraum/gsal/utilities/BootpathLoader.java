/**
 *
 * Copyright (c) 2013.10.04
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.verbindungsraum.gsal.utilities;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class BootpathLoader
{
  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param preparedValues String
   *
   * @return String
   */
  public static String getBootPath(String preparedValues)
  {
    String[] arguments = preparedValues.split("@@@");

    for(int i = 0; i < arguments.length; i++)
    {
      String[] singleVals = arguments[i].split("=");

      if(singleVals[0].equalsIgnoreCase("path"))
      {
        return singleVals[1];
      }
    }

    return "not_defined";
  }
}


/* ||\
 * ---------------------------------------------------------
 */
