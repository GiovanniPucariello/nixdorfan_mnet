/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.utilities.swing.MenuCheck.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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
