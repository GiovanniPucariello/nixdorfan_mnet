/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.bootstrap.impl.ConsoleValuesPreparator.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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
