/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.verbindungsraum.gsal.utilities.BootpathLoader.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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
