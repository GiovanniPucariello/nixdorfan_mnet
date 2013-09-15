/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.utilities.clone.CloneUtil.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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
