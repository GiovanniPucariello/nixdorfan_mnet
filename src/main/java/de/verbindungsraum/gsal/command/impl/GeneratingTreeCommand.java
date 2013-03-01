/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.verbindungsraum.gsal.command.impl;

import de.bite.framework.context.IContext;
import de.bite.framework.context.extension.impl.ContextStatus;
import de.verbindungsraum.gsal.command.IGSALCommand;
import de.verbindungsraum.gsal.exception.GSALCommandException;
import de.verbindungsraum.gsal.listener.GSALMouseListener;
import de.verbindungsraum.gsal.models.GSALTreeModel;
import de.verbindungsraum.gsal.models.TreeNodeGenerator;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

/**
 *
 * @author nixdorfan
 */
public class GeneratingTreeCommand implements IGSALCommand {

    private IContext context;
    private String commandStringPath;
    private JScrollPane scroll;
    private JTree propertiesTree = null;
    private static GeneratingTreeCommand command = null;
    private boolean isTreeAlreadySet = false;
    
    private GeneratingTreeCommand(){
    }
    
    @Override
    public void setContext(IContext context) {
        this.context = context;
    }

    @Override
    public void setCommandString(String controller_name) {
        this.commandStringPath = controller_name; 
    }

    @Override
    public void setGUIInforamtion(Object objectFromGUI) {
        this.scroll = (JScrollPane)objectFromGUI;
    }

    @Override
    public void execute() throws GSALCommandException {
        
        if( propertiesTree == null){
            propertiesTree = new JTree();
        }
        TreeNodeGenerator nodeGen = new TreeNodeGenerator( this.context );            
        GSALTreeModel treemodel = new GSALTreeModel( nodeGen.getRootNode( this.commandStringPath ));
        GSALMouseListener mouseListen = new GSALMouseListener(this.context, propertiesTree);
        propertiesTree.setModel( treemodel );
        propertiesTree.addMouseListener(mouseListen);
        propertiesTree.setRootVisible(true);
        propertiesTree.setVisible( true );
        propertiesTree.setFont(new java.awt.Font("Arial", 0, 10));
        if( isTreeAlreadySet == false){
            this.scroll.add(propertiesTree);
            this.scroll.setViewportView(propertiesTree);
            isTreeAlreadySet = true;
            this.context.setObject(ContextStatus.AKTIV, propertiesTree, "modtree", null);
        }
    }


    // Singelton Pattern zur Darstellung des JTrees
    public static IGSALCommand getInstance() {
        if (command == null){
            command = new GeneratingTreeCommand();
            return command; 
        } else {
            return command;
        }
    }
}
