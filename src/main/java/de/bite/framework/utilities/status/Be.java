/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.utilities.status.Be.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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
