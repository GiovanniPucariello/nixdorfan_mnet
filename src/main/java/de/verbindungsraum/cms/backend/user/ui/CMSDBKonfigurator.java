/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

package de.verbindungsraum.cms.backend.user.ui;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.context.IContext;
import de.bite.framework.utilities.db.Datenbank;

import de.verbindungsraum.cms.backend.user.ui.db.info.DBInfoTreeBuilder;
import de.verbindungsraum.cms.backend.user.ui.db.navigation.INavigator;
import de.verbindungsraum.cms.backend.user.ui.db.querybuilder.IQueryBuilder;
import de.verbindungsraum.gsal.models.GSALTreeModel;

//~--- JDK imports ------------------------------------------------------------

import java.io.FileReader;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;

import javax.swing.JScrollPane;
import javax.swing.JTree;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author AN
 */
public class CMSDBKonfigurator extends javax.swing.JFrame
{

  //~--- fields ---------------------------------------------------------------

  private IContext                context;
  private Datenbank               db;
  private int                     backward_counter;
  private int                     forward_counter;
  private String                  resultArea = "";
  private LinkedList< Integer >   forward    = new LinkedList< Integer >();
  private LinkedList< Integer >   backward   = new LinkedList< Integer >();
  private INavigator              navigator;
  private IQueryBuilder           qBuilder;

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel      bwfw_panel;
  private javax.swing.JPanel      dbkonf_dbinfo;
  private javax.swing.JPanel      dbkonf_konfigcontainer;
  private javax.swing.JPanel      dbkonf_manualiv;
  private javax.swing.JPanel      filler_panel_1;
  private javax.swing.JPanel      filler_panel_2;
  private javax.swing.JPanel      iv_actions;
  private javax.swing.JPanel      iv_result_ov;
  private javax.swing.JPanel      iv_scripting_ui;
  private javax.swing.JButton     jButton1;
  private javax.swing.JButton     jButton2;
  private javax.swing.JButton     jButton3;
  private javax.swing.JPanel      jPanel1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTree       jTree1;
  private javax.swing.JTextArea   result_area;
  private javax.swing.JScrollPane resultscroll_pane;
  private javax.swing.JEditorPane scripting_editor;
  private javax.swing.JScrollPane scriptingscroll_pane;

  //~--- constructors ---------------------------------------------------------

  /**
   * Creates new form CMSDBKonfigurator
   */
  public CMSDBKonfigurator()
  {
    initComponents();
  }




  //~--- methods --------------------------------------------------------------

  // Basismethode bite.framework fuer DI

  /**
   * 
   * @param context IContext
   */
  public void setContext(IContext context)
  {
    this.context = context;

    initDBCon();
  }

  /**
   */
  public void initDBCon()
  {
    this.db = (Datenbank)this.context.getObject("cms.datenbank", ContextType.NEW, null);

    this.db.setKonfig(load());

    this.navigator = (INavigator)this.context.getObject("cms.ui.dbkonf.navigator", ContextType.NEW, null);
    this.qBuilder  = (IQueryBuilder)this.context.getObject("cms.ui.dbkonf.querybuilder", ContextType.NEW, null);
  }

  /**
   *
   * @return Properties
   */
  private Properties load()
  {
    Properties properties = new Properties();

    try
    {
      properties.load(new FileReader((String)this.context.getStringValueFromProperties("cms.db.conf")));

      return properties;
    }
    catch(Exception ex)
    {
      this.context.getLogger().error("getDBProperties() NO Properties could be loaded ... " + ex);

      return new Properties();
    }
  }

  /**
   */
  public void initTree()
  {

    DBInfoTreeBuilder treeBuilder = new DBInfoTreeBuilder();

    treeBuilder.setContext(this.context);
    treeBuilder.setDatenbank(this.db);

    GSALTreeModel treemodel  = new GSALTreeModel(treeBuilder.getTreeItems());
    JTree         dbinfoTree = new JTree();

    dbinfoTree.setModel(treemodel);
    dbinfoTree.setRootVisible(true);
    dbinfoTree.setVisible(true);
    dbinfoTree.setFont(new java.awt.Font("Arial", 0, 10));

    JScrollPane pane = new JScrollPane();

    pane.setViewportView(dbinfoTree);
    pane.setVisible(true);
    this.dbkonf_dbinfo.add(pane);
    this.dbkonf_dbinfo.setVisible(true);
    pack();

  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    jScrollPane2           = new javax.swing.JScrollPane();
    jTree1                 = new javax.swing.JTree();
    dbkonf_konfigcontainer = new javax.swing.JPanel();
    dbkonf_dbinfo          = new javax.swing.JPanel();
    dbkonf_manualiv        = new javax.swing.JPanel();
    iv_actions             = new javax.swing.JPanel();
    jButton1               = new javax.swing.JButton();
    bwfw_panel             = new javax.swing.JPanel();
    jButton2               = new javax.swing.JButton();
    jButton3               = new javax.swing.JButton();
    filler_panel_1         = new javax.swing.JPanel();
    filler_panel_2         = new javax.swing.JPanel();
    jPanel1                = new javax.swing.JPanel();
    iv_scripting_ui        = new javax.swing.JPanel();
    scriptingscroll_pane   = new javax.swing.JScrollPane();
    scripting_editor       = new javax.swing.JEditorPane();
    iv_result_ov           = new javax.swing.JPanel();
    resultscroll_pane      = new javax.swing.JScrollPane();
    result_area            = new javax.swing.JTextArea();

    jTree1.setFont(new java.awt.Font("Arial", 0, 10));                                                // NOI18N
    jScrollPane2.setViewportView(jTree1);
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("DB-Editor v0.1");
    setPreferredSize(new java.awt.Dimension(700, 700));
    dbkonf_konfigcontainer.setPreferredSize(new java.awt.Dimension(400, 700));
    dbkonf_konfigcontainer.setLayout(new java.awt.BorderLayout());
    dbkonf_dbinfo.setPreferredSize(new java.awt.Dimension(300, 300));
    dbkonf_dbinfo.setLayout(new java.awt.BorderLayout());
    dbkonf_konfigcontainer.add(dbkonf_dbinfo, java.awt.BorderLayout.WEST);
    dbkonf_manualiv.setPreferredSize(new java.awt.Dimension(582, 400));
    dbkonf_manualiv.setLayout(new java.awt.BorderLayout());
    iv_actions.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 10)));    // NOI18N
    iv_actions.setFont(new java.awt.Font("Arial", 0, 10));                                            // NOI18N
    iv_actions.setPreferredSize(new java.awt.Dimension(150, 200));
    iv_actions.setLayout(new java.awt.GridLayout(4, 0));
    jButton1.setFont(new java.awt.Font("Arial", 0, 10));                                              // NOI18N
    jButton1.setText("Run Query");
    jButton1.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        jButton1ActionPerformed(evt);
      }
    });
    iv_actions.add(jButton1);
    bwfw_panel.setLayout(new java.awt.GridLayout(1, 2));
    jButton2.setText("<<");
    jButton2.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        jButton2ActionPerformed(evt);
      }
    });
    bwfw_panel.add(jButton2);
    jButton3.setText(">>");
    jButton3.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        jButton3ActionPerformed(evt);
      }
    });
    bwfw_panel.add(jButton3);
    iv_actions.add(bwfw_panel);

    javax.swing.GroupLayout filler_panel_1Layout = new javax.swing.GroupLayout(filler_panel_1);

    filler_panel_1.setLayout(filler_panel_1Layout);
    filler_panel_1Layout.setHorizontalGroup(filler_panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 138, Short.MAX_VALUE));
    filler_panel_1Layout.setVerticalGroup(filler_panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 134, Short.MAX_VALUE));
    iv_actions.add(filler_panel_1);

    javax.swing.GroupLayout filler_panel_2Layout = new javax.swing.GroupLayout(filler_panel_2);

    filler_panel_2.setLayout(filler_panel_2Layout);
    filler_panel_2Layout.setHorizontalGroup(filler_panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 138, Short.MAX_VALUE));
    filler_panel_2Layout.setVerticalGroup(filler_panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 134, Short.MAX_VALUE));
    iv_actions.add(filler_panel_2);
    dbkonf_manualiv.add(iv_actions, java.awt.BorderLayout.WEST);
    jPanel1.setLayout(new java.awt.GridLayout(2, 0));
    iv_scripting_ui.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Query-Editor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 10)));    // NOI18N
    iv_scripting_ui.setPreferredSize(new java.awt.Dimension(400, 200));
    iv_scripting_ui.setLayout(new java.awt.BorderLayout());
    scripting_editor.setFont(new java.awt.Font("Arial", 0, 14));                                      // NOI18N
    scriptingscroll_pane.setViewportView(scripting_editor);
    iv_scripting_ui.add(scriptingscroll_pane, java.awt.BorderLayout.CENTER);
    jPanel1.add(iv_scripting_ui);
    iv_result_ov.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Query-Results", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 10)));    // NOI18N
    iv_result_ov.setPreferredSize(new java.awt.Dimension(350, 200));
    iv_result_ov.setLayout(new java.awt.BorderLayout());
    result_area.setColumns(20);
    result_area.setFont(new java.awt.Font("Arial", 0, 14));                                           // NOI18N
    result_area.setRows(5);
    resultscroll_pane.setViewportView(result_area);
    iv_result_ov.add(resultscroll_pane, java.awt.BorderLayout.CENTER);
    jPanel1.add(iv_result_ov);
    dbkonf_manualiv.add(jPanel1, java.awt.BorderLayout.CENTER);
    dbkonf_konfigcontainer.add(dbkonf_manualiv, java.awt.BorderLayout.CENTER);
    getContentPane().add(dbkonf_konfigcontainer, java.awt.BorderLayout.CENTER);
    pack();

  }    // </editor-fold>//GEN-END:initComponents

  /**
   * 
   * @param evt java.awt.event.ActionEvent
   */
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
  {    // GEN-FIRST:event_jButton1ActionPerformed

    // Navigation
    this.navigator.setActualNavigationPoint(scripting_editor.getText());

    // Query and Result
    HashMap< String, String > qResult = this.qBuilder.getResult(scripting_editor.getText());
    StringBuilder             builder = new StringBuilder();

    builder.append("========================================");
    builder.append("\n");
    builder.append("Query-Result " + new Date());
    builder.append("\n");

    for(String singleVal : qResult.keySet())
    {
      builder.append("\n");
      builder.append(singleVal);
      builder.append(" :==: ");
      builder.append(qResult.get(singleVal));
      builder.append("\n");
    }

    // write new Infos
    resultArea += result_area.getText();

    result_area.setText(resultArea + "\n" + builder.toString());
  }    // GEN-LAST:event_jButton1ActionPerformed

  /**
   * 
   * @param evt java.awt.event.ActionEvent
   */
  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
  {    // GEN-FIRST:event_jButton2ActionPerformed
    scripting_editor.setText(this.navigator.getBackwardNavigationPoint());
  }    // GEN-LAST:event_jButton2ActionPerformed

  /**
   * 
   * @param evt java.awt.event.ActionEvent
   */
  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)
  {    // GEN-FIRST:event_jButton3ActionPerformed
    scripting_editor.setText(this.navigator.getForwardNavigationPoint());
  }    // GEN-LAST:event_jButton3ActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[])
  {

    /* Set the Nimbus look and feel */

    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">

    /*
     *  If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try
    {
      for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
      {
        if("Nimbus".equals(info.getName()))
        {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    }
    catch(ClassNotFoundException ex)
    {
      java.util.logging.Logger.getLogger(CMSDBKonfigurator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch(InstantiationException ex)
    {
      java.util.logging.Logger.getLogger(CMSDBKonfigurator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch(IllegalAccessException ex)
    {
      java.util.logging.Logger.getLogger(CMSDBKonfigurator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch(javax.swing.UnsupportedLookAndFeelException ex)
    {
      java.util.logging.Logger.getLogger(CMSDBKonfigurator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new CMSDBKonfigurator().setVisible(true);
      }
    });
  }

  // End of variables declaration//GEN-END:variables
}


/* ||\
 * ---------------------------------------------------------
 */
