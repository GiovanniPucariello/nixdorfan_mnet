/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.utilities.clone;

//~--- JDK imports ------------------------------------------------------------

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//~--- classes ----------------------------------------------------------------

/**
 * @author      nixdorfan
 */
public class CloneUtil
{
  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param objectToClone Object
   * @return      cloned object
   *
   * @note        tricky deep clone. Object has to be implement the serializable interface
   *
   * @throws Exception
   */
  public static Object deepCopy(Object objectToClone) throws Exception
  {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    new ObjectOutputStream(baos).writeObject(objectToClone);

    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

    return new ObjectInputStream(bais).readObject();
  }
}


/* ||\
 * ---------------------------------------------------------
 */
