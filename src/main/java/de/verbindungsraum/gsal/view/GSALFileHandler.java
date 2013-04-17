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

import de.bite.framework.context.extension.impl.ContextStatus;
import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.context.IContext;
import de.bite.framework.utilities.file.FileHandler;
import de.bite.framework.utilities.swing.PopUpper;
import de.bite.framework.utilities.system.SystemInformation;

import de.verbindungsraum.gsal.command.impl.GeneratingTreeCommand;
import de.verbindungsraum.gsal.exception.GSALException;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Window;

import java.io.File;

import javax.swing.JTree;
import javax.swing.tree.TreePath;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author an
 */
public class GSALFileHandler extends javax.swing.JFrame
{

  //~--- fields ---------------------------------------------------------------

  private IContext               context;
  public boolean                 isNew  = false;
  public boolean                 isCopy = false;

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton    jButton1;
  private javax.swing.JLabel     jLabel1;
  private javax.swing.JLabel     jLabel2;
  private javax.swing.JLabel     jLabel3;
  private javax.swing.JPanel     jPanel1;
  private javax.swing.JTextField jTextField1;

  //~--- constructors ---------------------------------------------------------

  /**
   * Creates new form GSALFileHandler
   *
   * @param context IContext
   */
  public GSALFileHandler(IContext context)
  {
    initComponents();

    this.context = context;
  }




  //~--- methods --------------------------------------------------------------

  /**
   * 
   * @param whatToDo String
   */
  public void load(String whatToDo)
  {
    if(whatToDo.equals("new"))
    {
      isNew = true;
    }
    else if(whatToDo.equals("copy"))
    {
      isCopy = true;
    }
    else
    {
      PopUpper upper = (PopUpper)this.context.getObject("popupper", ContextType.USED, null);

      upper.showPopUp("Nur Kopieren oder neu erstellen moeglich. ");
      this.dispose();
    }

    jLabel2.setText((String)context.getObject("pathtree", ContextType.NEW, null));
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
   * regenerated by th.e Form Editor.
   */
  @SuppressWarnings("unchecked")

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    jPanel1     = new javax.swing.JPanel();
    jLabel1     = new javax.swing.JLabel();
    jLabel2     = new javax.swing.JLabel();
    jLabel3     = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();
    jButton1    = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Datei bezeichnen");
    jLabel1.setFont(new java.awt.Font("Arial", 0, 10));        // NOI18N
    jLabel1.setText("aktuelles Verzeichnis für KonfigurationsDateien : ");
    jLabel2.setFont(new java.awt.Font("Arial", 0, 10));        // NOI18N
    jLabel3.setFont(new java.awt.Font("Arial", 0, 10));        // NOI18N
    jLabel3.setText("Name Datei:");
    jTextField1.setFont(new java.awt.Font("Arial", 0, 10));    // NOI18N
    jButton1.setFont(new java.awt.Font("Arial", 0, 10));       // NOI18N
    jButton1.setText("Übernehmen");
    jButton1.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        jButton1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);

    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18,
            18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel1,
              javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 195, Short.MAX_VALUE)).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10,
                10).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jButton1).addGap(0, 0,
                  Short.MAX_VALUE)).addComponent(jTextField1).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 246,
                    javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                      javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))).addContainerGap()));
    jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
      jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
        javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(
          jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(
          jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
            jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
            javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton1).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    pack();

  }    // </editor-fold>//GEN-END:initComponents

  /**
   * 
   * @param evt java.awt.event.ActionEvent
   */
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
  {    // GEN-FIRST:event_jButton1ActionPerformed

    String path          = jLabel2.getText() + SystemInformation.getFileSeparator();
    String pathToNewFile = path + jTextField1.getText();

    if(isCopy == true)
    {
      JTree  jTree         = (JTree)this.context.getObject("modtree", ContextType.USED, null);
      String selectionName = this.getPathFromTreePath(jTree.getSelectionPath());

      new FileHandler().copyOneFile(path + selectionName, pathToNewFile);
    }

    if(isNew == true)
    {
      File file = new File(pathToNewFile);

      try
      {
        file.createNewFile();
      }
      catch(Exception ex)
      {
        this.context.getLogger().error("Datei gleichen Namens existiert bereits im Dateienbaumes " + ex);
      }
    }

    try
    {
      GeneratingTreeCommand treeCommand = (GeneratingTreeCommand)context.getObject("treecommand", ContextType.USED, null);

      treeCommand.execute();
    }
    catch(GSALException ex)
    {
      this.context.getLogger().error("Fehler beim Aufbau des aktualisierten Dateienbaumes " + ex);

      PopUpper popException = (PopUpper)this.context.getObject("popupper", ContextType.USED, null);

      popException.showPopUp("Fehler beim Aufbau des aktualisierten Dateienbaumes ");
    }

    this.dispose();

  }    // GEN-LAST:event_jButton1ActionPerformed

  // End of variables declaration//GEN-END:variables
}


/* ||\
 * ---------------------------------------------------------
 */
