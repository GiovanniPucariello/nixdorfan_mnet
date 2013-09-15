/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.start.StarterExample.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

package de.bite.framework.start;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.bootstrap.impl.Bootstrap;
import de.bite.framework.bootstrap.impl.ConsoleValuesPreparator;
import de.bite.framework.context.extension.impl.ContextStatus;
import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.context.IContext;
import de.bite.framework.controller.Controller;
import de.bite.framework.utilities.db.Datenbank;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class StarterExample
{
  //~--- methods --------------------------------------------------------------

  /**
   * @param args the command line argumentses
   */
  public static void main(String[] args)
  {
    try
    {

      /** B o o t s t r a p Context */
      IContext   context  = Bootstrap.startContext(ConsoleValuesPreparator.prepare(args));

      // L A D E  Controller und uebergib Referenz
      Controller controll = (Controller)context.getObject("default.controller", ContextType.NEW, null);

      controll.dispatch();
      context.getObjectHistory();
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
    }
  }
}


/* ||\
 * ---------------------------------------------------------
 */
