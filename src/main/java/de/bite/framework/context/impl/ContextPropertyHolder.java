/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.context.impl;

//~--- JDK imports ------------------------------------------------------------

import java.util.Properties;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class ContextPropertyHolder
{

  //~--- fields ---------------------------------------------------------------

  private String     name;
  private Properties properties;

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param propertiesName String
   */
  public void setName(String propertiesName)
  {
    this.name = propertiesName;
  }

  /**
   *
   * @return String
   */
  public String getName()
  {
    return this.name;
  }

  /**
   *
   * @return Properties
   */
  public Properties getProperties()
  {
    return properties;
  }

  /**
   *
   * @param properties Properties
   */
  public void setProperties(Properties properties)
  {
    this.properties = properties;
  }

  /**
   *
   * @param key String
   *
   * @return String
   */
  public String getProperties(String key)
  {
    return this.properties.getProperty(key);
  }

  /**
   *
   * @param key String
   *
   * @return boolean
   */
  public boolean containsKey(String key)
  {
    return this.properties.containsKey(key);
  }

  /**
   *
   * @param value String
   *
   * @return boolean
   */
  public boolean containsValue(String value)
  {
    return this.properties.containsValue(value);
  }
}


/* ||\
 * ---------------------------------------------------------
 */
