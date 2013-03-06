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
* @(#)NodeGenerator.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.swing;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.constants.Constants;
import de.bite.framework.context.extension.impl.ContextStatus;
import de.bite.framework.context.IContext;
import de.bite.framework.context.extension.impl.ContextType;
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
public class NodeGenerator
{

  //~--- fields ---------------------------------------------------------------

  private IContext               iContext = null;
  private DefaultMutableTreeNode rooter   = new DefaultMutableTreeNode();
  private Logger                 logger   = Logger.getLogger(NodeGenerator.class);
  private TreeUserContext treecontext = null;

  //~--- constructors ---------------------------------------------------------

  /**
   *
   * @param iContext Context
   */
  public NodeGenerator(IContext iContext)
  {
    this.iContext = iContext;
    this.treecontext = (TreeUserContext)this.iContext.getObject("treecontext", ContextType.NEW,null);
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

    try
    {
      this.iContext.setObject(ContextStatus.AKTIV, this.rooter, "root_node", null);
      logger.info(Constants.info_message + " Knoten (Nodes) fuer Baumstruktur generiert ... ");
    }
    catch(Exception ex)
    {
      logger.error(Constants.error_message + " Root-Node konnte in Context nicht gesetzt werden ... ");
    }

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
          String         aryFileName = arr[i].getPath();
          String         fileName    = aryFileName.substring(aryFileName.lastIndexOf(SystemInformation.getFileSeparator()) + 1);
          TreeUserObject user        = new TreeUserObject();

          user.setType("file");
          user.setName(fileName);
          user.setPath(aryFileName);

          DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(fileName); 
          this.treecontext.setTreeUserObject( fileName, user);
          node.add(tempNode);
          user.setNodeIndex(node.getIndex(tempNode));
          
          logger.info(Constants.info_message + " Knoten (Nodes) fuer File wird generiert :: " + fileName);
        }
        else
        {
          String         aryDirName = arr[i].getPath();
          String         dirName    = aryDirName.substring(aryDirName.lastIndexOf(SystemInformation.getFileSeparator()) + 1);
          TreeUserObject user       = new TreeUserObject();

          user.setType("dir");
          user.setName(dirName);
          user.setPath(aryDirName);

          DefaultMutableTreeNode tempDirNode = new DefaultMutableTreeNode(dirName);

          this.treecontext.setTreeUserObject( dirName, user);
          
          node.add(tempDirNode);
          user.setNodeIndex(node.getIndex(tempDirNode));
          
          logger.info(Constants.info_message + " Knoten (Nodes) fuer Directory wird generiert :: " + dirName);
          this.createTree(tempDirNode, aryDirName);
        }
      }
      this.iContext.setObject(ContextStatus.AKTIV, this.treecontext, "tree_context",null);
    }
    catch(Exception ex)
    {
      logger.error(Constants.error_message + " Fehler bei Erstellung der Baumstruktur :: " + ex);
    }

  }
}


/* ||\
 * ---------------------------------------------------------
 */
