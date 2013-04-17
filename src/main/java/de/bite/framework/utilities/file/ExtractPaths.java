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
* @(#)ExtractPaths.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.file;

//~--- JDK imports ------------------------------------------------------------

import java.util.StringTokenizer;
import java.util.Vector;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class ExtractPaths
{
  //~--- fields ---------------------------------------------------------------

  StringTokenizer strTok;

  //~--- constructors ---------------------------------------------------------

  /** Creates a new instance of ExtractPaths */
  public ExtractPaths() {}




  /**
   *
   * @param theToken String
   * @param theDelim String
   */
  public ExtractPaths(String theToken, String theDelim)
  {
    strTok = new StringTokenizer(theToken, theDelim);
  }




  //~--- methods --------------------------------------------------------------

  /**
   * Testfunktion fuer MPI
   *
   * @param thefileEntry String
   *
   * @return Vector
   */
  public Vector returnPathTokens(String thefileEntry)
  {
    Vector pathTokens = new Vector();

    while(strTok.hasMoreElements())
    {
      String forExtraction = strTok.nextToken();
      String extractedPath = forExtraction.substring(forExtraction.indexOf(thefileEntry) + 1, forExtraction.lastIndexOf(thefileEntry));

      pathTokens.add(extractedPath);
    }

    return pathTokens;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
