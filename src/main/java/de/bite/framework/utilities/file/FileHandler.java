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
* @(#)FileHandler.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.file;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.constants.Constants;

import org.apache.log4j.Logger;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class FileHandler
{

  //~--- static fields --------------------------------------------------------

  private static Logger logger = Logger.getLogger(FileHandler.class);

  //~--- fields ---------------------------------------------------------------

  private Vector directoryNames = new Vector();
  ArrayList      fileAry        = new ArrayList();

  //~--- constructors ---------------------------------------------------------

  /** Konstruktor */
  public FileHandler() {}




  //~--- methods --------------------------------------------------------------

  /**
   * copy the given path and all files and directories within that path
   *
   * @param outputFile String
   * @param path String
   * @param newDir String
   */
  public void copyAll(String outputFile, String path, String newDir)
  {

    try
    {
      int         len   = path.length();
      File        fout  = new File(outputFile);
      PrintWriter pw    = new PrintWriter(new FileWriter(outputFile, true));
      File        f     = new File(path);
      File        arr[] = f.listFiles();

      for(int i = 0; i < arr.length; i++)
      {
        if(arr[i].isFile())
        {
          File myFile = new File(newDir + (arr[i].getPath()).substring(len));

          FileUtilsAN.copyFiles(new File((arr[i].getPath())), new File(newDir + ((arr[i].getPath()).substring(len))));
        }
        else
        {
          File myFile = new File(newDir + (arr[i].getPath()).substring(len));

          myFile.mkdir();
          this.copyAll(outputFile, arr[i].getPath() + '/', myFile.getPath() + '/');
        }
      }

      pw.close();
    }
    catch(Exception ex)
    {
      logger.error(Constants.error_message + ex.getLocalizedMessage());
    }

  }

  /**
   * copy all files within certain path into one directory
   *
   * @param outputFile String
   * @param path String
   * @param newDir String
   */
  public void copyAllToOnePath(String outputFile, String path, String newDir)
  {

    try
    {
      int  len   = path.length();
      File f     = new File(path);
      File arr[] = f.listFiles();

      for(int i = 0; i < arr.length; i++)
      {
        if(arr[i].isFile())
        {
          String arrpath = arr[i].getPath();

          if((arrpath.indexOf(".JPG") != -1) || (arrpath.indexOf(".jpg") != -1) || (arrpath.indexOf(".png") != -1) || (arrpath.indexOf(".gif") != -1))
          {
            File myFile = new File(newDir + arrpath.substring(len));

            FileUtilsAN.copyFiles(new File(arrpath), new File(newDir + (arrpath.substring(len))));

            // delete after copy
            arr[i].delete();
          }
        }
        else
        {
          File myFile = new File(newDir + (arr[i].getPath()).substring(len));

          this.copyAll(outputFile, arr[i].getPath() + '/', myFile.getPath() + '/');
        }
      }
    }
    catch(Exception ex)
    {
      logger.error(Constants.error_message + ex.getLocalizedMessage());
    }

  }

  /**
   *
   * @param fileToCopy String
   * @param copyToNewPlace String
   */
  public void copyOneFile(String fileToCopy, String copyToNewPlace)
  {
    try
    {
      FileUtilsAN.copyFiles(new File(fileToCopy), new File(copyToNewPlace));
    }
    catch(Exception ex)
    {
      logger.error(Constants.error_message + ex.getLocalizedMessage());
    }
  }

  /** show actual time when copy action is starting */
  public void beginCopy()
  {
    logger.info(Constants.info_message + " Starte FileHandler ... ");
  }

  /** show actual time when copy action is ending */
  public void endCopy()
  {
    logger.info(Constants.info_message + " Stoppe FileHandler ... ");
  }

  /**
   * delete the given path (String deletepath)
   *
   * @param deletepath String
   */
  public void deleteAll(String deletepath)
  {
    try
    {
      String del = deletepath;

      this.deleteAllFiles(del);
      new File(del).delete();
    }
    catch(Exception ex)
    {
      logger.error(Constants.error_message + ex.getLocalizedMessage());
    }
  }

  /**
   *  delete the files within the given path (String deletepath)
   *  to delete the remaining directory use deleteAll(String deletepath)
   *
   * @param del String
   */
  public void deleteAllFiles(String del)
  {

    try
    {
      int  len           = del.length();
      File filesToDelete = new File(del);
      File arr[]         = filesToDelete.listFiles();

      for(int i = 0; i < arr.length; i++)
      {
        if(arr[i].isFile())
        {
          new File(arr[i].getPath()).delete();
        }

        if(arr[i].isDirectory())
        {
          directoryNames.add(arr[i].getPath());
          this.deleteAllFiles(arr[i].getPath());
          new File(arr[i].getPath()).delete();
        }
      }
    }
    catch(Exception ex)
    {
      logger.error(Constants.error_message + ex.getLocalizedMessage());
    }

  }

  /**
   * delete one file
   *
   * @param del String
   */
  public void deleteOneFile(String del)
  {
    try
    {
      File filesToDelete = new File(del);

      filesToDelete.delete();
    }
    catch(Exception ex)
    {
      logger.error(Constants.error_message + ex.getLocalizedMessage());
    }
  }

  /**
   * get all files and directories from one path
   *
   * @param rootDir String
   *
   * @return ArrayList
   */
  public ArrayList getPathsAndFiles(String rootDir)
  {

    try
    {
      File f     = new File(rootDir);
      File arr[] = f.listFiles();

      for(int i = 0; i < arr.length; i++)
      {
        if(arr[i].isFile())
        {
          this.fileAry.add("File__" + arr[i].getPath());
        }
        else
        {
          arr[i].getPath();
          this.fileAry.add("Directory__" + arr[i].getPath());
          this.getPathsAndFiles(arr[i].getPath());
        }
      }
    }
    catch(Exception ex)
    {
      logger.error(Constants.error_message + ex.getLocalizedMessage());

      return null;
    }

    return this.fileAry;

  }

  ;

  //~--- methods --------------------------------------------------------------

  /**
   * noch zu klaeren fuer was MEthode gedacht war
   *
   * @param rootDir String
   */
  public void verfiyFiles(String rootDir)
  {
    logger.info(Constants.impl_message);
  }

  ;

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param path String
   * @return Pfadangabe wurde erfolgreich geprueft
   * @deprecated arbeitet nur korrekt auf Linux Maschinen
   *
   * Geprueft wird ob der aus verschiedenen Verzeichnissen bestehende Pfad valide ist, also die Verzeichnisse existieren
   * Wenn Verzeichnisse nicht existieren, werden diese sukkzessive angelegt.
   * Die Prüfuing findet immer von links nach rechts statt. D.h die ersten Verzeichnisse bilden die Grundlage fuer folgende
   * Verzeichnisse.
   *
   */
  @Deprecated
  public boolean checkPathAndCreateDirectories(String path)
  {

    logger.info(Constants.info_message + " analysiere Pfad: " + path);

    String   pathToCheck   = "";
    String[] aryWithTokens = path.split("/");

    for(int i = 0; i < aryWithTokens.length; i++)
    {
      try
      {
        pathToCheck = pathToCheck + "/" + aryWithTokens[i];

        if(i == 0)
        {
          try
          {
            if(aryWithTokens[0].length() == 0)
            {

              // Nichts zu tun
            }
            else
            {
              if((aryWithTokens[0].charAt(1) == ':') && (aryWithTokens[0] != ""))
              {
                pathToCheck = aryWithTokens[0];
              }
            }
          }
          catch(Exception ex)
          {
            logger.error(Constants.error_message + ex.getLocalizedMessage());

            return false;
          }
        }

        if((i > 0) && (i < aryWithTokens.length - 1))
        {
          File fileToCheck = new File(pathToCheck);

          if((fileToCheck.isDirectory() == false) && !fileToCheck.isFile())
          {
            fileToCheck.mkdir();
            logger.info(Constants.info_message + " erstelle neues Verzeichnis: " + fileToCheck);
          }
          else
          {
            logger.info(Constants.info_message + " File / Verzeichnis vorhanden: " + fileToCheck);
          }
        }
      }
      catch(Exception ex)
      {
        logger.error(Constants.error_message + ex.getLocalizedMessage());
      }
    }

    return true;

  }

  /**
   *
   * @param path String
   * @param split String
   * @return Pfadangabe wurde erfolgreich geprueft
   *
   * Geprueft wird ob der aus verschiedenen Verzeichnissen bestehende Pfad valide ist, also die Verzeichnisse existieren
   * Wenn Verzeichnisse nicht existieren, werden diese sukkzessive angelegt.
   * Die Prüfuing findet immer von links nach rechts statt. D.h die ersten Verzeichnisse bilden die Grundlage fuer folgende
   * Verzeichnisse.
   *
   */
  public boolean checkPathAndCreateDirectories(String path, String split)
  {

    logger.info(Constants.info_message + " analysiere Pfad: " + path);

    String   pathToCheck   = "";
    String[] aryWithTokens = path.split(split);

    for(int i = 0; i < aryWithTokens.length; i++)
    {
      try
      {
        pathToCheck = pathToCheck + split + aryWithTokens[i];

        if(i == 0)
        {
          try
          {
            if(aryWithTokens[0].length() == 0)
            {

              // Nichts zu tun
            }
            else
            {
              if((aryWithTokens[0].charAt(1) == ':') && (aryWithTokens[0] != ""))
              {
                pathToCheck = aryWithTokens[0];
              }
            }
          }
          catch(Exception ex)
          {
            logger.error(Constants.error_message + ex.getLocalizedMessage());

            return false;
          }
        }

        if((i > 0) && (i < aryWithTokens.length - 1))
        {
          File fileToCheck = new File(pathToCheck);

          if((fileToCheck.isDirectory() == false) && !fileToCheck.isFile())
          {
            fileToCheck.mkdir();
            logger.info(Constants.info_message + " erstelle neues Verzeichnis: " + fileToCheck);
          }
          else
          {
            logger.info(Constants.info_message + " File / Verzeichnis vorhanden: " + fileToCheck);
          }
        }
      }
      catch(Exception ex)
      {
        logger.error(Constants.error_message + ex.getLocalizedMessage());
      }
    }

    return true;

  }

  /**
   *
   * @param path HashMap
   * @param operating_system String
   * @return Pfadangabe wurde erfolgreich geprueft
   *
   * Geprueft wird ob der aus verschiedenen Verzeichnissen bestehende Pfad valide ist, also die Verzeichnisse existieren
   * Wenn Verzeichnisse nicht existieren, werden diese sukkzessive angelegt.
   * Die Prüfuing findet immer von links nach rechts statt. D.h die ersten Verzeichnisse bilden die Grundlage fuer folgende
   * Verzeichnisse.
   *
   */
  public boolean checkPathAndCreateDirectories(HashMap path, String operating_system)
  {

    logger.info(Constants.info_message + " analysiere Pfad: " + path.toString());

    String  pathToCheck = "";
    String  delimiter   = "";
    boolean windows     = false;
    boolean linux       = false;

    // Ueberpruefe OS
    if(operating_system.toLowerCase().indexOf("linux") != -1)
    {
      linux     = true;
      delimiter = "/";
    }

    if(operating_system.toLowerCase().indexOf("windows") != -1)
    {
      windows   = true;
      delimiter = "\\";
    }

    for(int i = 0; i < path.size(); i++)
    {
      try
      {
        pathToCheck = pathToCheck + delimiter + (String)path.get(i + "");

        if((i == 0) && linux)
        {
          pathToCheck = "";
          pathToCheck = delimiter + (String)path.get(i + "");
        }

        if((i == 0) && windows)
        {
          pathToCheck = "";
          pathToCheck = (String)path.get(i) + delimiter;
        }

        if(i > 0)
        {
          File fileToCheck = new File(pathToCheck);

          if((fileToCheck.isDirectory() == false) && !fileToCheck.isFile())
          {
            fileToCheck.mkdir();
            logger.info(Constants.info_message + " erstelle neues Verzeichnis: " + fileToCheck);
          }
          else
          {
            logger.info(Constants.info_message + " File / Verzeichnis vorhanden: " + fileToCheck);
          }
        }
      }
      catch(Exception ex)
      {
        logger.error(Constants.error_message + ex.getLocalizedMessage());
      }
    }

    return true;

  }
}


/* ||\
 * ---------------------------------------------------------
 */
