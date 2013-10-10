/**
 *
 * Copyright (c) 2013.10.04
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.bite.framework.utilities.file;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.utilities.system.SystemInformation;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @version        1.0, 2013.08.09
 * @author         bas
 */
public class DefaultPathVerificationCheckModul extends PathValidationCheckModul
{

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param path String
   *
   * @return boolean
   */
  @Override
  public boolean isValidPath(String path)
  {

    // detect System
    String os = SystemInformation.getOS();

    // System.out.println(os);
    if(os.toLowerCase().indexOf("linux") != -1)
    {
      if(path.startsWith("/"))
      {

        // this is a basepath within unix
        return true;
      }
      else
      {

        // seems to be part of a path
        return false;
      }
    }

    if(os.toLowerCase().indexOf("windows") != -1)
    {
      if(path.indexOf(":") != -1)
      {

        // this seems to be a basepath within windows. Dirty hack to be fast :)
        return true;
      }
      else
      {

        // seems to be part of a path
        return false;
      }
    }

    // only works with linux an windows. no mac supported :))
    return false;
  }

  /**
   *
   * @param path String
   *
   * @return String
   */
  @Override
  public String getVerifcatedPath(String path)
  {

    if(isValidPath(path))
    {
      if(isFile(path))
      {
        return path;
      }
      else
      {

        // this.context.getLogger().error("DefaultPathVerificationCheckModul ::: getVerifcatedPath(" + path + ") ist KEIN GUELTIGES File ");
        return null;
      }
    }
    else
    {
      String basepath             = (String)this.context.getObject("basepath", ContextType.USED, null);
      String completeRelativePath = basepath + "/" + path;

      if(isFile(completeRelativePath))
      {
        return completeRelativePath;
      }
      else
      {

        // this.context.getLogger().error("DefaultPathVerificationCheckModul ::: getVerifcatedPath(" + completeRelativePath + ") ist KEIN GUELTIGES File ");
        return null;
      }
    }

  }

  /**
   *
   * @param path String
   *
   * @return boolean
   */
  @Override
  public boolean isFile(String path)
  {

    File f;

    try
    {
      boolean fileExists;

      f = new File(path);

      if(f.exists())
      {
        fileExists = true;
      }
      else
      {
        fileExists = false;
      }

      f = null;

      return fileExists;
    }
    catch(Exception ex)
    {
      ex.printStackTrace();

      return false;
    }
    finally
    {
      f = null;
    }

  }

  /**
   *
   * @param key String
   *
   * @return boolean
   */
  @Override
  public boolean isRequestForPath(String key)
  {

    // not yet implemented
    return false;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
