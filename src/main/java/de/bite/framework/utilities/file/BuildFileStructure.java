/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.utilities.file.BuildFileStructure.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

/*
* @(#)BuildFileStructure.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.file;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;

import java.util.Vector;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class BuildFileStructure
{

  //~--- fields ---------------------------------------------------------------

  String path;
  Vector vecForAll, vecForFiles, vecForDirs, vecForErr;

  //~--- constructors ---------------------------------------------------------

  /** Creates a new instance of BuildFileStructure */
  public BuildFileStructure()
  {
    vecForFiles = new Vector();
    vecForDirs  = new Vector();
    vecForErr   = new Vector();
  }




  //~--- methods --------------------------------------------------------------

  /**
   * Analysis of files within the path
   *
   * @param path String
   *
   * @return Vector
   */

  // TODO: Umbau auf neueren Datentyp e.g. ArrayList, ...
  public Vector viewFiles(String path)
  {

    try
    {
      File f     = new File(path);
      File arr[] = f.listFiles();

      for(int i = 0; i < arr.length; i++)
      {
        if(arr[i].isFile())
        {
          vecForFiles.add(arr[i].getPath());
        }
        else
        {
          this.viewFiles(arr[i].getPath());
        }
      }
    }
    catch(Exception ex)
    {
      vecForErr.add(ex);

      return vecForErr;
    }

    return vecForFiles;

  }

  /**
   * Analysis of directories within the path
   *
   * @param path String
   *
   * @return Vector
   */
  public Vector viewDirs(String path)
  {

    try
    {
      File f     = new File(path);
      File arr[] = f.listFiles();

      for(int i = 0; i < arr.length; i++)
      {
        if(arr[i].isDirectory())
        {
          vecForDirs.add(arr[i].getPath());
          this.viewDirs(arr[i].getPath());
        }
      }
    }
    catch(Exception ex)
    {
      vecForErr.add(ex);

      return vecForErr;
    }

    return vecForDirs;

  }
}


/* ||\
 * ---------------------------------------------------------
 */
