/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.utilities.system.SystemInformation.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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

import java.io.IOException;

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

  /**
   *
   * @return Long
   */
  public static Long getUsedMemoryInMB()
  {
    Long free = Runtime.getRuntime().freeMemory();
    Long max  = Runtime.getRuntime().maxMemory();

    return((max - free) / 1000000);
  }

  /**
   *
   * @return Long
   */
  public static Long getFreeMemoryInMB()
  {
    Long free = Runtime.getRuntime().freeMemory();

    return((free) / 1000000);
  }

  /**
   *
   * @return Long
   */
  public static Long getMaxMemoryInMB()
  {
    Long free = Runtime.getRuntime().maxMemory();

    return((free) / 1000000);
  }

  /**
   */
  public static void useGC()
  {
    Runtime.getRuntime().gc();
  }

  /**
   *
   * @param pathToApp String
   *
   * @throws IOException
   */
  public static void executeApp(String pathToApp) throws IOException
  {
    Runtime.getRuntime().exec(pathToApp);
  }
}


/* ||\
 * ---------------------------------------------------------
 */
