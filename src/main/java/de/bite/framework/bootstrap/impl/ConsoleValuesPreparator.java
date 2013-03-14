/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.bootstrap.impl;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class ConsoleValuesPreparator
{
  //~--- methods --------------------------------------------------------------

  /**
   * 
   * @param args String[]
   *
   * @return String
   */
  public static String prepare(String[] args)
  {
    StringBuilder builder = new StringBuilder();

    for(int i = 0; i < args.length; i++)
    {
      if(i == 0)
      {
        builder.append(args[i]);
      }
      else
      {
        builder.append("@@@" + args[i]);
      }
    }

    return builder.toString();
  }
}


/* ||\
 * ---------------------------------------------------------
 */
