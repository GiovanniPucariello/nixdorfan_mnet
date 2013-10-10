/**
 *
 * Copyright (c) 2013.10.04
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.verbindungsraum.gsal.command.impl;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.extension.impl.ContextStatus;
import de.bite.framework.context.IContext;

import de.verbindungsraum.gsal.command.IGSALCommand;
import de.verbindungsraum.gsal.exception.GSALCommandException;
import de.verbindungsraum.gsal.listener.GSALMouseListener;
import de.verbindungsraum.gsal.models.GSALTreeModel;
import de.verbindungsraum.gsal.models.TreeNodeGenerator;

//~--- JDK imports ------------------------------------------------------------

import javax.swing.JScrollPane;
import javax.swing.JTree;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class GeneratingTreeCommand implements IGSALCommand
{

  //~--- static fields --------------------------------------------------------

  private static GeneratingTreeCommand command = null;

  //~--- fields ---------------------------------------------------------------

  private IContext    context;
  private String      commandStringPath;
  private JScrollPane scroll;
  private JTree       propertiesTree   = null;
  private boolean     isTreeAlreadySet = false;

  //~--- constructors ---------------------------------------------------------

  /**
   */
  private GeneratingTreeCommand() {}




  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param context IContext
   */
  @Override
  public void setContext(IContext context)
  {
    this.context = context;
  }

  /**
   *
   * @param controller_name String
   */
  @Override
  public void setCommandString(String controller_name)
  {
    this.commandStringPath = controller_name;
  }

  /**
   *
   * @param objectFromGUI Object
   */
  @Override
  public void setGUIInforamtion(Object objectFromGUI)
  {
    this.scroll = (JScrollPane)objectFromGUI;
  }

  /**
   *
   * @throws GSALCommandException
   */
  @Override
  public void execute() throws GSALCommandException
  {

    if(propertiesTree == null)
    {
      propertiesTree = new JTree();
    }

    TreeNodeGenerator nodeGen     = new TreeNodeGenerator(this.context);
    GSALTreeModel     treemodel   = new GSALTreeModel(nodeGen.getRootNode(this.commandStringPath));
    GSALMouseListener mouseListen = new GSALMouseListener(this.context, propertiesTree);

    propertiesTree.setModel(treemodel);
    propertiesTree.addMouseListener(mouseListen);
    propertiesTree.setRootVisible(true);
    propertiesTree.setVisible(true);
    propertiesTree.setFont(new java.awt.Font("Arial", 0, 10));

    if(isTreeAlreadySet == false)
    {
      this.scroll.add(propertiesTree);
      this.scroll.setViewportView(propertiesTree);

      isTreeAlreadySet = true;

      this.context.setObject(ContextStatus.AKTIV, propertiesTree, "modtree", null);
    }

  }

  // Singelton Pattern zur Darstellung des JTrees

  /**
   *
   * @return IGSALCommand
   */
  public static IGSALCommand getInstance()
  {
    if(command == null)
    {
      command = new GeneratingTreeCommand();

      return command;
    }
    else
    {
      return command;
    }
  }
}


/* ||\
 * ---------------------------------------------------------
 */
