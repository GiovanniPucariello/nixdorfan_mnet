/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.verbindungsraum.gsal.view;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.bootstrap.impl.PropertyLoader;
import de.bite.framework.constants.Constants;
import de.bite.framework.context.extension.impl.ContextStatus;
import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.context.IContext;
import de.bite.framework.controller.Controller;
import de.bite.framework.utilities.file.FileHandler;
import de.bite.framework.utilities.file.FileUtilsAN;
import de.bite.framework.utilities.swing.PopUpper;
import de.bite.framework.utilities.system.SystemInformation;

import de.verbindungsraum.gsal.command.IGSALCommand;
import de.verbindungsraum.gsal.command.impl.*;
import de.verbindungsraum.gsal.exception.GSALCommandException;
import de.verbindungsraum.gsal.exception.GSALException;
import de.verbindungsraum.gsal.listener.GSALActionListener;
import de.verbindungsraum.gsal.models.GSALTreeModel;
import de.verbindungsraum.gsal.models.TreeNodeGenerator;
import de.verbindungsraum.gsal.utilities.ModulAnalyzer;

import org.apache.log4j.Logger;

//~--- JDK imports ------------------------------------------------------------

import java.io.*;

import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.UIManager;
import org.hsqldb.Server;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class GSALView extends javax.swing.JFrame
{

  //~--- fields ---------------------------------------------------------------

  private IContext                         context;
  private String                           pathToFileOrDirectory;
  private Logger                           logger = Logger.getLogger(GSALView.class);
  private ProgrammStarterCommand           dbStarter;
  private ProgrammStarterCommand           puttyStarter;
  private ProgrammStarterCommand           winscpStarter;
  private Server server;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

  //~--- constructors ---------------------------------------------------------

  /**
   * Creates new form GSALView
   *
   * @param context IContext
   * @param pathToFileOrDirectory String
   */
  public GSALView(IContext context, String pathToFileOrDirectory)
  {

    this.context               = context;
    this.pathToFileOrDirectory = pathToFileOrDirectory;

    try
    {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
    }

    initComponents();
    loadJMenuModulItems();
    this.context.getLogger().setGUIObject(this.jTextArea1);

    PopUpper pop = new PopUpper();

    pop.setVars(this);
    this.context.setObject(ContextStatus.AKTIV, pop, "popupper", null);

    GSALFileHandler filehandler = new GSALFileHandler(this.context);

    this.context.setObject(ContextStatus.AKTIV, filehandler, "filehandler", null);

  }




  //~--- methods --------------------------------------------------------------

  /**
   */
  private void loadJMenuModulItems()
  {
    try
    {
      List< JMenuItem > menuItemList = ModulAnalyzer.getActualItems(this.pathToFileOrDirectory);

      for(JMenuItem item : menuItemList)
      {
        GSALCommand command = new GSALCommand();

        command.setContext(this.context);
        command.setCommandString(item.getText());
        item.addActionListener(new GSALActionListener(command));
        jMenu1.add(item);
      }
    }
    catch(GSALException gsalex)
    {
      this.context.getLogger().error(Constants.error_message + "  " + gsalex);
      gsalex.printStackTrace();
    }
  }

  /*
   * Eigene Methoden -- Erhalte TreePath-String dynamischer Tiefe
   */

  /**
   *
   * @param treepath TreePath
   *
   * @return String
   */
  private String getPathFromTreePath(TreePath treepath)
  {
    try
    {
      int    lengthOfTreePath         = treepath.getPath().length;
      String returnTreePathObjectName = treepath.getPath()[lengthOfTreePath - 1] + "";

      return returnTreePathObjectName;
    }
    catch(Exception ex)
    {
      PopUpper pop = (PopUpper)this.context.getObject("popupper", ContextType.NEW, null);

      pop.showPopUp("Bitte vor Markierung File im Dateienbaum markieren");

      return null;
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GSAL - [Global System and Application Launcher] Version 1.0");
        setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jTabbedPane1.setName(""); // NOI18N

        jScrollPane1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTabbedPane1.addTab("LogFiles", jScrollPane1);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);
        jTabbedPane1.getAccessibleContext().setAccessibleName("Logging");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        jMenu1.setText("geladene Module");
        jMenu1.setToolTipText("");
        jMenu1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setText("externe Programme");
        jMenu2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jMenu2.add(jSeparator4);

        jMenuItem2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jMenuItem2.setText("Start embedded DB-Server");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);
        jMenu2.add(jSeparator5);

        jMenuItem5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jMenuItem5.setText("Stop embedded DB-Server");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);
        jMenu2.add(jSeparator9);

        jMenuItem6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jMenuItem6.setText("Threads");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);
        jMenu2.add(jSeparator7);

        jMenuItem3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jMenuItem3.setText("PuTTY");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);
        jMenu2.add(jSeparator6);

        jMenuItem8.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jMenuItem8.setText("WinSCP");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Tools");
        jMenu3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenu3.add(jSeparator1);

        jMenuItem4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jMenuItem4.setText(" Logging - External-Logging (Tab LogFIles)");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem7.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jMenuItem7.setText("RELOAD Logging - External-Logging (Tab LogFIles)");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);
        jMenu3.add(jSeparator2);
        jMenu3.add(jSeparator8);

        jMenuItem1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jMenuItem1.setText("Shell starten");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);
        jMenu3.add(jSeparator3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        this.server.stop();
        this.context.getLogger().info("Server stopped ... ");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        GSALThreadViewer threadsV = new GSALThreadViewer();
        threadsV.setContext(context);
        threadsV.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

  /**
   *
   * @param evt java.awt.event.ActionEvent
   */
  private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt)
  {

    // TODO add your handling code here:
  }

  /**
   *
   * @param evt java.awt.event.ActionEvent
   */
  private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt)
  {

  if(this.server == null)
  {
    try
    {
      this.context.getLogger().info(" Starte DB-Server ... ");
      server = new Server();
      server.setTrace(Boolean.getBoolean((String)this.context.getStringValueFromProperties("default.db.trace")));
      server.setAddress((String)this.context.getStringValueFromProperties("default.db.address"));
      server.setPort(Integer.parseInt((String)this.context.getStringValueFromProperties("default.db.port")));

      server.setDatabasePath(0, (String)this.context.getStringValueFromProperties("default.db.file")); 
      server.setDatabaseName(0, (String)this.context.getStringValueFromProperties("default.db.name"));

      server.start();

    }
    catch(Exception ex)
    {
        ex.printStackTrace();
        this.context.getLogger().error(Constants.error_message + " Command executing external programm dbserver " + ex.getLocalizedMessage());
    }
  }
  else
  {
    PopUpper implementedException = (PopUpper)this.context.getObject("popupper", ContextType.USED, null);

    implementedException.showPopUp(" Server ist bereits gestartet ... ");
  }
    PopUpper implementedException = (PopUpper)this.context.getObject("popupper", ContextType.USED, null);

    implementedException.showPopUp(" DB-StartFeature noch nicht integriert. Bitte unter GSAL-Verszeichnis gsal/hsqldb/bin/runServer.bat starten ... ");
  }

  /**
   *
   * @param evt java.awt.event.ActionEvent
   */
  private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt)
  {

    if(puttyStarter == null)
    {
      puttyStarter = new ProgrammStarterCommand();

      puttyStarter.setContext(this.context);
      puttyStarter.setCommandString(this.context.getStringValueFromProperties("default.programms.putty"));
      puttyStarter.setGUIInforamtion(null);

      try
      {
        puttyStarter.execute();
      }
      catch(GSALCommandException ex)
      {
        this.context.getLogger().error(Constants.error_message + " Command executing external programm Putty " + ex.getLocalizedMessage());
      }
    }
    else
    {
      try
      {
        puttyStarter.execute();
      }
      catch(GSALCommandException ex)
      {
        logger.error(Constants.error_message + " Command executing external programm WinSCP " + ex.getLocalizedMessage());
      }
    }

  }

  /**
   *
   * @param evt java.awt.event.ActionEvent
   */
  private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt)
  {

    JFileChooser fileChooser = new JFileChooser();

    fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    fileChooser.setVisible(true);

    int returnVal = fileChooser.showOpenDialog(jMenu3);

    if(returnVal == JFileChooser.APPROVE_OPTION)
    {
      String                 filePath = fileChooser.getSelectedFile().toString();
      ExternalLoggingCommand command  = new ExternalLoggingCommand();

      command.setContext(this.context);
      command.setCommandString(filePath);
      command.setGUIInforamtion(this.jTextArea1);
      this.context.setObject(ContextStatus.AKTIV, command, "externalLogging", null);

      try
      {
        command.execute();
      }
      catch(GSALCommandException ex)
      {
        this.context.getLogger().error(Constants.error_message + " LoggingCommand external logging :: execute  " + ex.getLocalizedMessage());
      }
    }

  }

  /**
   *
   * @param evt java.awt.event.ActionEvent
   */
  private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt)
  {
    IGSALCommand command = (ExternalLoggingCommand)this.context.getObject("externalLogging", ContextType.NEW, null);

    try
    {
      command.execute();
    }
    catch(GSALCommandException ex)
    {
      this.context.getLogger().error(Constants.error_message + "RELOAD LoggingCommand external logging :: execute  " + ex.getLocalizedMessage());
    }
  }

  /**
   *
   * @param evt java.awt.event.ActionEvent
   */
  private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt)
  {

    if(winscpStarter == null)
    {
      winscpStarter = new ProgrammStarterCommand();

      winscpStarter.setContext(this.context);
      winscpStarter.setCommandString(this.context.getStringValueFromProperties("default.programms.winscp"));
      winscpStarter.setGUIInforamtion(null);

      try
      {
        winscpStarter.execute();
      }
      catch(GSALCommandException ex)
      {
        this.context.getLogger().error(Constants.error_message + " Command executing external programm WinSCP " + ex.getLocalizedMessage());
      }
    }
    else
    {
      try
      {
        winscpStarter.execute();
      }
      catch(GSALCommandException ex)
      {
        this.context.getLogger().error(Constants.error_message + " Command executing external programm WinSCP " + ex.getLocalizedMessage());
      }
    }

  }

  /**
   *
   * @param evt java.awt.event.ActionEvent
   */
  private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt)
  {
    SwingShell shell = new SwingShell();

    shell.showGUI();
  }

  // End of variables declaration
}


/* ||\
 * ---------------------------------------------------------
 */
