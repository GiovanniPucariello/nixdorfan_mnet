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
* @(#)MenuCheck.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.swing;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Component;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class MenuCheck
{

  //~--- constructors ---------------------------------------------------------

  /**
   */
  public MenuCheck()
  {

    // allgemeiner super-Konstruktor
  }




  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param jM JMenu
   *
   * @return String
   */
  public String extractMenuItem(JMenu jM)
  {

    Component[]  comp;
    String       selected = "nicht initialisiert";
    StringBuffer menuName, extractMenuName, name;
    int          checksum = 0;

    comp = jM.getMenuComponents();

    for(int i = 0; i < comp.length; i++)
    {
      menuName        = new StringBuffer(comp[i].getClass().getName());
      extractMenuName = menuName.reverse();
      name            = new StringBuffer(extractMenuName.substring(0, extractMenuName.indexOf(".")));

      String theCorrectObject = name.reverse().toString();

      if((theCorrectObject.equalsIgnoreCase("JCheckBoxMenuItem")) == true)
      {
        JCheckBoxMenuItem chBM = (JCheckBoxMenuItem)comp[i];

        if(chBM.getState() == true)
        {
          checksum = checksum + 1;

          if(checksum == 1)
          {
            Object[] obj = new Object[1];

            obj      = chBM.getSelectedObjects();
            selected = (String)obj[0];

            // System.out.println(checksum);
          }

          if(checksum > 1)
          {
            selected = "Checksumfehler" + "\n";

            // System.out.println(checksum);
          }
        }
      }
    }

    return selected;

  }
}


/* ||\
 * ---------------------------------------------------------
 */
