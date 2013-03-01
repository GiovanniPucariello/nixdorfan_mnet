/**
 *
 * Copyright (c) 2012.03.08
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_01-b08
 * 
 */

/*
* @(#)SystemInformation.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.system;

//~--- JDK imports ------------------------------------------------------------

import java.util.Properties;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class SystemInformation
{

  //~--- methods --------------------------------------------------------------

  /**
   *
   * "file.separator"     Character that separates components of a file path. This is "/" on UNIX and "\" on Windows.
   * "java.class.path"       Path used to find directories and JAR archives containing class files. Elements of the class path are separated by a platform-specific character specified in the path.separator property.
   * "java.home"     Installation directory for Java Runtime Environment (JRE)
   * "java.vendor"   JRE vendor name
   * "java.vendor.url"       JRE vendor URL
   * "java.version"  JRE version number
   * "line.separator"        Sequence used by operating system to separate lines in text files
   * "os.arch"       Operating system architecture
   * "os.name"       Operating system name
   * "os.version"    Operating system version
   * "path.separator"        Path separator character used in java.class.path
   * "user.dir"      User working directory
   * "user.home"     User home directory
   * "user.name"     User account name
   *
   * @return String
   */
  public static String getOS()
  {
    return System.getProperty("os.name");
  }

  /**
   *
   * @return String
   */
  public static String getFileSeparator()
  {
    return System.getProperty("file.separator");
  }

  /**
   *
   * @return String
   */
  public static String getSystemFileSeparatorForStringReadings()
  {
    String os = getOS().toLowerCase();

    if(os.indexOf("linux") != -1)
    {
      return System.getProperty("file.separator");
    }
    else if(os.indexOf("windows") != -1)
    {
      return(System.getProperty("file.separator") + "\\");
    }
    else
    {
      return System.getProperty("file.separator");
    }
  }

  /**
   *
   * @return Properties
   */
  public static Properties getSystemProperties()
  {
    return System.getProperties();
  }

  /**
   *
   * @param protcol String
   *
   * @return String
   */
  public static String getFileProtocolChars(String protcol)
  {
    String returnString     = "file:";
    String linuxSeparator   = "///";
    String windowsSeparator = "\\\\\\";
    String os               = getOS().toLowerCase();

    if(os.indexOf("linux") != -1)
    {
      returnString += linuxSeparator;
    }
    else
    {
      returnString += windowsSeparator;
    }

    return returnString;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
