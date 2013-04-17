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
* @(#)JClock.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.status;

//~--- JDK imports ------------------------------------------------------------

//------------------------------------------------------------------------------
//maincomments

/*
==========================================================================================================================
JClock
Copyright c 2006
{( programmierloesungen )
        Dr. rer. nat. Andreas Nixdorf
        Erhard-Auer-Str. 5
        Muehldorf am Inn;
        Tel.: auf e-mail-Anfrage
        www.verbindungsraum.de
}
==========================================================================================================================
*/

//------------------------------------------------------------------------------
//imports
import java.text.DateFormat;

import java.util.Date;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class JClock extends JLabel implements Runnable
{
  //~--- fields ---------------------------------------------------------------

//-------------------------------------------------------------------------------------------------------
// MEMBERVARIABLEN
  DateFormat df = DateFormat.getTimeInstance();

  //~--- constructors ---------------------------------------------------------

//-------------------------------------------------------------------------------------------------------
//      KONSTRUKTOREN

  /**
   */
  public JClock()
  {
    super();

    initClock();
  }




  //~--- methods --------------------------------------------------------------

//-------------------------------------------------------------------------------------------------------
//      METHODEN
//      Kontruktormethoden(1)

  /**
   */
  public void initClock()
  {
    this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

    Thread clock = new Thread(this);

    clock.start();
  }

  // vom Interface Runnable geforderte Methode

  /**
   */
  @Override
  public void run()
  {
    for(;;)
    {
      this.setText((df.format(new Date()).toString()));

      // zur Steigerung der Performance wird nur jede halbe Sekunde ausgegeben
      Be.idleFor(500);
    }
  }
}


/* ||\
 * ---------------------------------------------------------
 */
