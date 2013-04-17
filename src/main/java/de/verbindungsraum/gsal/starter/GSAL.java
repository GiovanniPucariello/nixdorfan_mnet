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
* @(#)GSAL.java   12/10/08
*
* @author nixdorfan
 */

/*
* @(#)GSAL.java   12/10/08
*
* @author nixdorfan
 */

/*
* @(#)GSAL.java   12/10/08
*
* @author nixdorfan
 */

/*
* @(#)GSAL.java   12/10/08
*
* @author nixdorfan
 */

/*
* @(#)GSAL.java   12/10/08
*
* @author nixdorfan
 */

/*
* @(#)GSAL.java   12/10/08
*
* @author nixdorfan
 */

/*
* @(#)GSAL.java   12/10/08
*
* @author nixdorfan
 */

/*
* @(#)GSAL.java   12/10/06
*
* @author nixdorfan
 */

/*
* @(#)GSAL.java   12/10/06
*
* @author nixdorfan
 */

/*
* @(#)GSAL.java   12/10/06
*
* @author nixdorfan
 */

/*
* @(#)GSAL.java   12/10/06
*
* @author nixdorfan
 */

/*
* @(#)GSAL.java   12/10/05
*
* @author nixdorfan
 */

/*
* @(#)GSAL.java   12/10/05
*
* @author nixdorfan
 */

/*
* @(#)GSAL.java   12/10/05
*
* @author nixdorfan
 */

/*
* @(#)GSAL.java   12/10/05
*
* @author nixdorfan
 */

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package de.verbindungsraum.gsal.starter;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.bootstrap.impl.Bootstrap;
import de.bite.framework.bootstrap.impl.ConsoleValuesPreparator;
import de.bite.framework.context.extension.impl.ContextStatus;
import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.context.IContext;
import de.bite.framework.controller.Controller;
import de.bite.framework.utilities.swing.PopUpper;

import de.verbindungsraum.gsal.threads.WatchDogStarter;
import de.verbindungsraum.gsal.utilities.ModulAnalyzer;
import de.verbindungsraum.gsal.view.GSALSplashScreen;
import de.verbindungsraum.gsal.view.GSALView;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.List;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class GSAL
{

  //~--- methods --------------------------------------------------------------

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args)
  {

    String  preparedArgs = ConsoleValuesPreparator.prepare(args);
    boolean useGUI       = true;
    String  process      = "not";

    for(int i = 0; i < args.length; i++)
    {
      if(args[i].indexOf("useGUI=false") != -1)
      {
        useGUI = false;
      }
    }

    if(useGUI == true)
    {
      GSALSplashScreen splashscreen  = new GSALSplashScreen();
      PopUpper         startPopUpper = new PopUpper();

      startPopUpper.setVars(splashscreen.getContentPane());

      try
      {
        splashscreen.setKonfig(preparedArgs);
        splashscreen.setVisible(true);
      }
      catch(Exception ex)
      {
        startPopUpper.showPopUp(" keine Pfade definiert. Bitte in der start_gsal.bat boot und editorpfad angeben ");
        ex.printStackTrace();
        throw new RuntimeException();
      }
    }
    else
    {

      try
      {
        String         pathForProperty = args[0].split("=")[1];
        List< String > modulesToLoad   = ModulAnalyzer.getActualItemsForConsole(pathForProperty);
        IContext       context         = Bootstrap.startContext(preparedArgs);

        context.setObject(ContextStatus.AKTIV, pathForProperty, "basepath", null);
        context.getLogger().info("basepath fuer watchdog extrahiert == " + pathForProperty);

        while(process.lastIndexOf("quit") == -1)
        {
          char          c   = 0;
          StringBuilder str = new StringBuilder();

          System.out.println("Bitte Befehl eingeben :");

          try
          {
            while((c = (char)System.in.read()) != '\n')
            {
              str.append(c);
            }
          }
          catch(IOException e)
          {

            // TODO Auto-generated catch block
            e.printStackTrace();
          }

          // process = str.toString().trim();
          System.out.println("Benutzereingabe: " + process);

          for(String command : modulesToLoad)
          {
            System.out.print("eingebbarer Befehl : " + command + "\n");

            if(command.equalsIgnoreCase(process))
            {
              if(command.equalsIgnoreCase("base") || command.equalsIgnoreCase("default"))
              {
                System.out.print("Befehl base oder default hat keinen Controller hinterlegt. Befehl war : " + command + " \n");
              }
              else
              {
                Controller controll = (Controller)context.getObject(process + ".controller", ContextType.NEW, null);

                controll.dispatch();
              }
            }
            else if(command.equalsIgnoreCase("quit"))
            {
              System.exit(0);
            }
          }
        }
      }
      catch(Exception ex)
      {
        ex.printStackTrace();
        throw new RuntimeException();
      }

    }

  }
}


/* ||\
 * ---------------------------------------------------------
 */
