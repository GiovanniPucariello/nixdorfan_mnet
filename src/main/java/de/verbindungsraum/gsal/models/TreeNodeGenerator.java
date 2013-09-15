/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.verbindungsraum.gsal.models.TreeNodeGenerator.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

package de.verbindungsraum.gsal.models;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.constants.Constants;
import de.bite.framework.context.IContext;
import de.bite.framework.utilities.system.SystemInformation;

import org.apache.log4j.Logger;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class TreeNodeGenerator
{

  //~--- fields ---------------------------------------------------------------

  private DefaultMutableTreeNode rooter  = new DefaultMutableTreeNode();
  private IContext               context = null;
  private Logger                 logger  = Logger.getLogger(TreeNodeGenerator.class);

  //~--- constructors ---------------------------------------------------------

  /**
   *
   * @param context IContext
   */
  public TreeNodeGenerator(IContext context)
  {
    this.context = context;
  }




  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param treePath TreePath
   *
   * @return String
   */
  public String getSelectionPath(TreePath treePath)
  {
    return null;
  }

  /**
   *
   * @param treePath TreePath
   *
   * @return String
   */
  public String getSelectedFileOrDirectory(TreePath treePath)
  {
    return null;
  }

  /**
   *
   * @param path String
   *
   * @return MutableTreeNode
   */
  public MutableTreeNode getRootNode(String path)
  {
    this.createTree(this.rooter, path);

    return this.rooter;
  }

  /**
   *
   * @param node DefaultMutableTreeNode
   * @param path String
   */
  private void createTree(DefaultMutableTreeNode node, String path)
  {

    try
    {
      File f     = new File(path);
      File arr[] = f.listFiles();

      for(int i = 0; i < arr.length; i++)
      {
        if(arr[i].isFile())
        {
          String                 aryFileName = arr[i].getPath();
          String                 fileName    = aryFileName.substring(aryFileName.lastIndexOf(SystemInformation.getFileSeparator()) + 1);
          DefaultMutableTreeNode tempNode    = new DefaultMutableTreeNode(fileName);

          this.context.getLogger().info(Constants.info_message + " FileNode == " + fileName);
          node.add(tempNode);
        }
        else
        {
          String                 aryDirName  = arr[i].getPath();
          String                 dirName     = aryDirName.substring(aryDirName.lastIndexOf(SystemInformation.getFileSeparator()) + 1);
          DefaultMutableTreeNode tempDirNode = new DefaultMutableTreeNode(dirName);

          this.context.getLogger().info(Constants.info_message + " DirNode == " + dirName);
          node.add(tempDirNode);
          this.createTree(tempDirNode, aryDirName);
        }
      }
    }
    catch(Exception ex)
    {
      this.context.getLogger().error(Constants.error_message + " " + ex);
      ex.printStackTrace();
    }

  }
}


/* ||\
 * ---------------------------------------------------------
 */
