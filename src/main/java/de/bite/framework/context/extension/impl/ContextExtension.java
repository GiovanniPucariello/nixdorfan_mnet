/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.context.extension.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.constants.Constants;
import de.bite.framework.context.extension.IContextExtension;
import de.bite.framework.context.IContext;
import de.bite.framework.exceptions.ContextExtensionException;
import de.bite.framework.utilities.clone.CloneUtil;

import org.apache.log4j.Logger;

//~--- JDK imports ------------------------------------------------------------

import java.io.Serializable;

import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class ContextExtension implements IContextExtension, Serializable
{

  //~--- static fields --------------------------------------------------------

  private static final long serialVersionUID = 1L;
  private static Logger     logger           = Logger.getLogger(ContextExtension.class);

  //~--- fields ---------------------------------------------------------------

  private String                           name                   = "not set";
  private HashMap< String, Object >        objectNameObject       = new HashMap< String, Object >();
  private HashMap< String, Long >          objectNameTime         = new HashMap< String, Long >();
  private HashMap< String, ContextStatus > objectNameStatus       = new HashMap< String, ContextStatus >();
  private HashMap< String, Object >        objectNameConversation = new HashMap< String, Object >();
  private IContext                         context;

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @return String
   */
  @Override
  public String getName()
  {
    return this.name;
  }

  /**
   *
   * @param name String
   *
   * @throws ContextExtensionException
   */
  @Override
  public void setName(String name) throws ContextExtensionException
  {
    if(!this.name.equals("not set"))
    {
      this.context.getLogger().error(Constants.error_message + name + " BEREITS GESETZT ");
      throw new ContextExtensionException(Constants.warning_message + " ContextExtension-Name ist bereits gesetzt");
    }

    this.name = name;
  }

  /**
   *
   * @param object Object
   * @param status ContextStatus
   * @param contextFlow String
   *
   * @throws ContextExtensionException
   */
  @Override
  public void set(Object object, ContextStatus status, String contextFlow) throws ContextExtensionException
  {
    try
    {
      process(object, status, contextFlow);
    }
    catch(Exception ex)
    {
      this.context.getLogger().error(Constants.error_message + " set(Object object) :: " + object.toString() + "  " + ex.getLocalizedMessage());
    }
  }

  /**
   *
   * @return Object
   */
  @Override
  public Object get()
  {
    for(String objectToReturn : this.objectNameStatus.keySet())
    {
      if((this.objectNameStatus.get(objectToReturn) == ContextStatus.CONVERSATION_AKTIV) || (this.objectNameStatus.get(objectToReturn) == ContextStatus.AKTIV))
      {
        this.context.getLogger().info(Constants.info_message + " Object == " + objectToReturn + " ::::: Status == " + this.objectNameStatus.get(objectToReturn) + " ::::: Timestamp == " +
                                      this.objectNameTime.get(objectToReturn));

        return this.objectNameObject.get(objectToReturn);
      }
    }

    this.context.getLogger().info(Constants.warning_message + " get aktives Object :: NICHT ERFOLGREICH fuer ConstextExtension " + this.getName());

    return null;
  }

  /**
   *
   * @param conversationFlow String
   * @note  Upper/Lower Case sensitiv! You know what you have to do ;-)
   *
   * @return Object
   *
   * @throws ContextExtensionException
   */
  @Override
  public Object get(String conversationFlow) throws ContextExtensionException
  {

    if(!this.objectNameConversation.containsValue(conversationFlow))
    {
      this.context.getLogger().info(Constants.warning_message + " get( String conversationFlow ) aktives Object fuer Conversation-Flow :: " + conversationFlow + " NICHT vorhanden fuer " +
                                    this.getName());

      return null;
    }

    for(Object objectToReturn : this.objectNameConversation.keySet())
    {
      if((this.objectNameConversation.get(objectToReturn).equals(conversationFlow)))
      {
        this.context.getLogger().info(Constants.info_message + " get( String conversationFlow ) aktives Object fuer Conversation-Flow :: " + conversationFlow + " ERFOLGREICH == " + objectToReturn +
                                      " fuer " + this.getName());

        return this.objectNameObject.get(objectToReturn);
      }
    }

    this.context.getLogger().info(Constants.warning_message + " get( String conversationFlow ) aktives Object :: NICHT definierbar fuer " + this.getName());

    return null;

  }

  /**
   *
   * @return Object[]
   */
  @Override
  public Object[] getObjectHistory()
  {
    Collection collection = this.objectNameObject.values();

    return collection.toArray();
  }

  /**
   *
   * @param object Object
   * @param status ContextStatus
   * @param contextFlow String
   *
   * @return boolean
   *
   * @throws ContextExtensionException
   */
  public boolean process(Object object, ContextStatus status, String contextFlow) throws ContextExtensionException
  {

    String objektName = "";

    // wenn Status nicht uebergeben, dann setze ihn auf aktiv
    if(status == null)
    {
      status = ContextStatus.AKTIV;
    }

    // noch kein Objekt gespeichert
    if(objectNameObject.size() == 0)
    {
      objektName = object.toString() + "_" + objectNameObject.size() + 1;

      this.objectNameObject.put(objektName, object);
      this.objectNameTime.put(objektName, new GregorianCalendar().getTimeInMillis());
      this.objectNameStatus.put(objektName, status);

      if(status.equals(ContextStatus.CONVERSATION_AKTIV))
      {
        this.objectNameConversation.put(objektName, contextFlow);
        this.context.getLogger().info(Constants.info_message + " set(Object object) :: Conversation-Status wird mit verarbeitet fuer " + this.getName());
      }

      this.context.getLogger().info(Constants.info_message + " set(Object object) :: ERFOLGREICH fuer ERSTEN Eintrag fuer " + this.getName());

      return true;
    }
    else if(status.equals(ContextStatus.CONVERSATION_AKTIV))
    {
      objektName = object.toString() + "_" + objectNameObject.size() + 1;

      // suche bislang aktives Objekt -- CONVERSATION
      for(String objectNamePersistent : this.objectNameStatus.keySet())
      {
        if(this.objectNameStatus.get(objectNamePersistent).equals(ContextStatus.CONVERSATION_AKTIV))
        {
          try
          {

            // verarbeite ALT
            Object getAktivObject = this.objectNameObject.get(objectNamePersistent);
            Object cloned         = CloneUtil.deepCopy(getAktivObject);

            this.objectNameObject.put(objectNamePersistent, cloned);
            this.objectNameStatus.put(objectNamePersistent, ContextStatus.CONVERSATION_COPY);

            // verarbeite NEU
            this.objectNameObject.put(objektName, object);
            this.objectNameTime.put(objektName, new GregorianCalendar().getTimeInMillis());
            this.objectNameStatus.put(objektName, ContextStatus.CONVERSATION_AKTIV);

            /**
             * !!!
             * gleich benannte Context-FLows werden ueberschrieben.
             * Damit koennen Werte in bestimmten Context-FLows veraendert werden
             * ABER: Der User muss wissen was er macht ;-)
             *
             */
            this.objectNameConversation.put(objektName, contextFlow);
            this.context.getLogger().info(Constants.info_message + " set(Object object) :: aktuelles Objekt unter diesem context-Flow wird ueberschrieben context-Flow == " + contextFlow + " fuer " +
                                          this.getName());

            /**  */
            this.context.getLogger().info(Constants.info_message + " set(Object object) :: ERFOLGREICH fuer Erweiterung Objektliste und Aktivitaets-Zustand Objekt fuer " + this.getName());

            return true;
          }
          catch(Exception ex)
          {
            throw new ContextExtensionException(Constants.error_message + " Klonierung Objekt fehlgeschlagen :: " + ex.getLocalizedMessage() + "fuer " + this.getName());
          }
        }
      }

      this.context.getLogger().info(Constants.warning_message + " set(Object object) :: UNKLAR fuer Erweiterung Objektliste und Aktivitaets-Zustand Objekt fuer " + this.getName());

      return false;
    }
    else
    {
      objektName = object.toString() + "_" + objectNameObject.size() + 1;

      // suche bislang aktives Objekt -- reines Objekt
      for(String objectNamePersistent : this.objectNameStatus.keySet())
      {
        if(this.objectNameStatus.get(objectNamePersistent) == ContextStatus.AKTIV)
        {
          try
          {

            // verarbeite ALT
            Object getAktivObject = this.objectNameObject.get(objectNamePersistent);
            Object cloned         = CloneUtil.deepCopy(getAktivObject);

            this.objectNameObject.put(objectNamePersistent, cloned);
            this.objectNameStatus.put(objectNamePersistent, ContextStatus.COPY);

            // verarbeite NEU
            this.objectNameObject.put(objektName, object);
            this.objectNameTime.put(objektName, new GregorianCalendar().getTimeInMillis());
            this.objectNameStatus.put(objektName, ContextStatus.AKTIV);
            this.context.getLogger().info(Constants.info_message + " set(Object object) :: ERFOLGREICH fuer Erweiterung Objektliste und Aktivitaets-Zustand Objekt fuer " + this.getName());

            return true;
          }
          catch(Exception ex)
          {
            throw new ContextExtensionException(Constants.error_message + " Klonierung Objekt fehlgeschlagen :: " + ex.getLocalizedMessage() + " fuer " + this.getName());
          }
        }
      }

      this.context.getLogger().info(Constants.warning_message + " set(Object object) :: UNKLAR fuer Erweiterung Objektliste und Aktivitaets-Zustand Objekt fuer " + this.getName());

      return false;
    }

  }

  /**
   * 
   * @param context IContext
   */
  @Override
  public void setContext(IContext context)
  {
    this.context = context;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
