/**
 *
 * Copyright (c) 2013.06.14
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0-b147
 * 
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
