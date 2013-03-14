/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.utilities.status;

//~--- classes ----------------------------------------------------------------

//------------------------------------------------------------------------------
//maincomments

/*
==========================================================================================================================
Be
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

/**
 *
 * @author         nixdorfan
 */
public class Be
{
  //~--- constructors ---------------------------------------------------------

  /**
   */
  public Be() {}




  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param l long
   */
  public static void idleFor(long l)
  {
    try
    {
      Thread.sleep(l);
    }
    catch(InterruptedException interruptedexception) {}
  }
}


/* ||\
 * ---------------------------------------------------------
 */
