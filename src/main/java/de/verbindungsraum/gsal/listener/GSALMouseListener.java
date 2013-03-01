
/**
 *
 * Copyright (c) 2012.03.08
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_01-b08
 * 
 */

package de.verbindungsraum.gsal.listener;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.IContext;
import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.utilities.file.FileUtilsAN;
import de.bite.framework.utilities.system.SystemInformation;



//~--- JDK imports ------------------------------------------------------------

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JEditorPane;
import javax.swing.JTree;
import javax.swing.tree.TreePath;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class GSALMouseListener implements MouseListener
{

  //~--- fields ---------------------------------------------------------------

  private IContext context;
  private JTree jTree;

  //~--- constructors ---------------------------------------------------------

  /**
   *
   * @param context IContext
   */
  public GSALMouseListener(IContext context, JTree jTree)
  {
    this.context = context;
    this.jTree = jTree;
  }




  //~--- methods --------------------------------------------------------------

  /**
   * 
   * @param evt MouseEvent
   */
  @Override
  public void mouseClicked(MouseEvent evt)
  {
      
    String selectionName = this.getPathFromTreePath( jTree.getSelectionPath() );
    this.context.getLogger().info("Selectionname "+selectionName);
    String path = (String)this.context.getObject("pathtree", ContextType.NEW, null);
    this.context.getLogger().info("path "+path);
    String pathToFile = path + SystemInformation.getFileSeparator() + selectionName;
    this.context.getLogger().info("path to file "+ pathToFile);
    JEditorPane editorpane = (JEditorPane)this.context.getObject("editorpane", ContextType.USED, null);
    this.context.getLogger().info(editorpane.toString());
    editorpane.setText(FileUtilsAN.readBuffered(pathToFile));
  }

  /**
   * 
   * @param e MouseEvent
   */
  @Override
  public void mousePressed(MouseEvent e)
  {
    //throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   * 
   * @param e MouseEvent
   */
  @Override
  public void mouseReleased(MouseEvent e)
  {
    //throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   * 
   * @param e MouseEvent
   */
  @Override
  public void mouseEntered(MouseEvent e)
  {
    //throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   * 
   * @param e MouseEvent
   */
  @Override
  public void mouseExited(MouseEvent e)
  {
    //throw new UnsupportedOperationException("Not supported yet.");
  }
  
      /*
     * Eigene Methoden -- Erhalte TreePath-String dynamischer Tiefe
     */
    private String getPathFromTreePath(TreePath treepath) {
        int lengthOfTreePath = treepath.getPath().length;
        String returnTreePathObjectName = treepath.getPath()[ lengthOfTreePath - 1] + "";
        return returnTreePathObjectName;
    }
}


/* ||\
 * ---------------------------------------------------------
 */
