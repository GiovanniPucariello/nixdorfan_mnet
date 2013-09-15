/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.utilities.file.PathValidationCheckModul.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

package de.bite.framework.utilities.file;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.IContext;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public abstract class PathValidationCheckModul
{
  //~--- fields ---------------------------------------------------------------

  public IContext context;

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param context IContext
   */
  public void setContext(IContext context)
  {
    this.context = context;
  }

  /**
   *
   * @param path String
   *
   * @return boolean
   */
  public abstract boolean isValidPath(String path);

  /**
   *
   * @param path String
   *
   * @return String
   */
  public abstract String getVerifcatedPath(String path);

  /**
   *
   * @param path String
   *
   * @return boolean
   */
  public abstract boolean isFile(String path);

  /**
   *
   * @param key String
   *
   * @return boolean
   */
  public abstract boolean isRequestForPath(String key);
}


/* ||\
 * ---------------------------------------------------------
 */
