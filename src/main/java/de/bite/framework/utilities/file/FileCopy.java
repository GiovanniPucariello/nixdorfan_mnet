/**
 *
 * Copyright (c) 2013.03.13
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_04-b22
 * 
 */

/*
* @(#)FileCopy.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.file;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.Date;
import java.util.Vector;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class FileCopy extends javax.swing.JFrame
{

  //~--- fields ---------------------------------------------------------------

  // End of variables declaration//GEN-END:variables
  // eigene Variablen
  private Vector                  directoryNames = new Vector();

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton     jButton1;
  private javax.swing.JLabel      jLabel1;
  private javax.swing.JLabel      jLabel2;
  private javax.swing.JLabel      jLabel3;
  private javax.swing.JLabel      jLabel4;
  private javax.swing.JPanel      jPanel1;
  private javax.swing.JPanel      jPanel2;
  private javax.swing.JPanel      jPanel3;
  private javax.swing.JPanel      jPanel4;
  private javax.swing.JPanel      jPanel5;
  private javax.swing.JPanel      jPanel6;
  private javax.swing.JPanel      jPanel7;
  private javax.swing.JPanel      jPanel8;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTextArea   jTextArea1;
  private javax.swing.JTextArea   jTextArea2;
  private boolean                 withGUI;

  //~--- constructors ---------------------------------------------------------

  /** Konstruktor */
  public FileCopy()
  {
    initComponents();
    initComponents2();
  }




  /**
   *
   * @param withGUI boolean
   */
  public FileCopy(boolean withGUI)
  {
    this.withGUI = withGUI;
  }




  //~--- methods --------------------------------------------------------------

  /**
   */
  private void initComponents()
  {    // GEN-BEGIN:initComponents

    jPanel1      = new javax.swing.JPanel();
    jPanel5      = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1   = new javax.swing.JTextArea();
    jPanel3      = new javax.swing.JPanel();
    jLabel3      = new javax.swing.JLabel();
    jPanel6      = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTextArea2   = new javax.swing.JTextArea();
    jPanel4      = new javax.swing.JPanel();
    jLabel4      = new javax.swing.JLabel();
    jPanel2      = new javax.swing.JPanel();
    jPanel8      = new javax.swing.JPanel();
    jLabel2      = new javax.swing.JLabel();
    jPanel7      = new javax.swing.JPanel();
    jLabel1      = new javax.swing.JLabel();
    jButton1     = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    setTitle(" file tools 1.0.0 ");
    addWindowListener(new java.awt.event.WindowAdapter()
    {
      @Override
      public void windowClosing(java.awt.event.WindowEvent evt)
      {
        exitForm(evt);
      }
    });
    jPanel1.setLayout(new java.awt.GridLayout(2, 1));
    jPanel1.setBorder(new javax.swing.border.TitledBorder(null, " protokollfelder", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Arial", 1, 10)));
    jPanel5.setLayout(new java.awt.BorderLayout());
    jScrollPane1.setViewportView(jTextArea1);
    jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);
    jPanel3.setLayout(new java.awt.GridLayout(1, 0));
    jLabel3.setFont(new java.awt.Font("Arial", 1, 10));
    jLabel3.setText(" kopierte Dateien : ");
    jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel3.add(jLabel3);
    jPanel5.add(jPanel3, java.awt.BorderLayout.NORTH);
    jPanel1.add(jPanel5);
    jPanel6.setLayout(new java.awt.BorderLayout());
    jScrollPane2.setViewportView(jTextArea2);
    jPanel6.add(jScrollPane2, java.awt.BorderLayout.CENTER);
    jPanel4.setLayout(new java.awt.GridLayout(1, 0));
    jLabel4.setFont(new java.awt.Font("Arial", 1, 10));
    jLabel4.setText(" meldungen :");
    jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel4.add(jLabel4);
    jPanel6.add(jPanel4, java.awt.BorderLayout.NORTH);
    jPanel1.add(jPanel6);
    getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    jPanel2.setLayout(new java.awt.GridLayout(2, 4));
    jPanel2.setBorder(new javax.swing.border.TitledBorder(null, " protokoll ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Arial", 1, 10)));
    jPanel8.setLayout(new java.awt.BorderLayout());
    jLabel2.setFont(new java.awt.Font("Arial", 1, 10));
    jLabel2.setIcon(new javax.swing.ImageIcon("bite1a.jpg"));
    jLabel2.setLabelFor(jLabel2);
    jLabel2.setText(" bite build 0809062325 ");
    jPanel8.add(jLabel2, java.awt.BorderLayout.CENTER);
    jPanel2.add(jPanel8);
    jPanel7.setLayout(new java.awt.BorderLayout());
    jPanel7.setPreferredSize(new java.awt.Dimension(195, 20));
    jPanel7.setVerifyInputWhenFocusTarget(false);
    jLabel1.setFont(new java.awt.Font("Arial", 1, 10));
    jLabel1.setText(" ... ");
    jLabel1.setBorder(new javax.swing.border.EtchedBorder(javax.swing.border.EtchedBorder.RAISED));
    jPanel7.add(jLabel1, java.awt.BorderLayout.CENTER);
    jButton1.setFont(new java.awt.Font("Arial", 1, 10));
    jButton1.setText(" anwendung schliessen ");
    jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jButton1.setDefaultCapable(false);
    jButton1.setEnabled(false);
    jButton1.addActionListener(new java.awt.event.ActionListener()
    {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        jButton1ActionPerformed(evt);
      }
    });
    jPanel7.add(jButton1, java.awt.BorderLayout.EAST);
    jPanel2.add(jPanel7);
    getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);
    pack();

  }    // GEN-END:initComponents

  /**
   *
   * @param evt java.awt.event.ActionEvent
   */
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
  {    // GEN-FIRST:event_jButton1ActionPerformed
    System.exit(0);
  }    // GEN-LAST:event_jButton1ActionPerformed

  /**
   */
  private void initComponents2()
  {
    this.setSize(500, 500);
    this.show();
  }

  /**
   * Exit the Application
   *
   * @param evt java.awt.event.WindowEvent
   */
  private void exitForm(java.awt.event.WindowEvent evt)
  {    // GEN-FIRST:event_exitForm

    // WindowListener deaktiviert, Anwendung nur �ber Button schlie�bar
    // System.exit(0);
  }    // GEN-LAST:event_exitForm

//------------------------------------------------------------------------------
// methods

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

//    if(fout.exists())
//    {
//            fout.delete();
//    }
      PrintWriter pw    = new PrintWriter(new FileWriter(outputFile, true));
      File        f     = new File(path);
      File        arr[] = f.listFiles();

      for(int i = 0; i < arr.length; i++)
      {
        if(arr[i].isFile())
        {
          File myFile = new File(newDir + (arr[i].getPath()).substring(len));

          FileUtilsAN.writeInputFile(new File((arr[i].getPath())), new File(newDir + ((arr[i].getPath()).substring(len))));

          // System.out.println((arr[i].getPath()));
          jTextArea1.append("> " + (arr[i].getPath()) + "\n");
          jTextArea1.setCaretPosition(this.getEndOfText());
          jTextArea1.append("> datei : " + (arr[i].getPath()).substring(len) + "\n");
        }
        else
        {
          File myFile = new File(newDir + (arr[i].getPath()).substring(len));

          myFile.mkdir();
          jTextArea1.append("> " + arr[i].getPath() + "\n");
          jTextArea1.setCaretPosition(this.getEndOfText());
          jTextArea1.append("> ordner : " + (arr[i].getPath()).substring(len) + "\n");
          this.copyAll(outputFile, arr[i].getPath() + '/', myFile.getPath() + '/');
        }
      }

      pw.close();
    }
    catch(Exception ex)
    {
      jTextArea2.append("> fehler aufgetreten : " + "\n");
      jTextArea2.append("> " + ex + "\n");
      jTextArea2.setCaretPosition(getEndOfText2());
    }

  }

  /**
   * copy the given path and all files and directories within that path
   *
   * @param withGUI boolean
   * @param outputFile String
   * @param path String
   * @param newDir String
   */
  public void copyAll(boolean withGUI, String outputFile, String path, String newDir)
  {

    if(withGUI)
    {
      copyAll(outputFile, path, newDir);
    }
    else
    {
      try
      {
        int         len   = path.length();
        File        fout  = new File(outputFile);

        // if(fout.exists())
        // {
        // fout.delete();
        // }
        PrintWriter pw    = new PrintWriter(new FileWriter(outputFile, true));
        File        f     = new File(path);
        File        arr[] = f.listFiles();

        for(int i = 0; i < arr.length; i++)
        {
          if(arr[i].isFile())
          {
            File myFile = new File(newDir + (arr[i].getPath()).substring(len));

            FileUtilsAN.writeInputFile(new File((arr[i].getPath())), new File(newDir + ((arr[i].getPath()).substring(len))));
          }
          else
          {
            File myFile = new File(newDir + (arr[i].getPath()).substring(len));

            myFile.mkdir();
            this.copyAll(false, outputFile, arr[i].getPath() + '/', myFile.getPath() + '/');
          }
        }

        pw.close();
      }
      catch(Exception ex)
      {
        System.out.println("> fehler aufgetreten : " + "\n");
      }
    }

  }

  /**
   * gets the maxCharCount of the Text returns the CharCount for
   *   setting the caretPosition
   *
   * @return int
   */
  public int getEndOfText()
  {
    String getPosition = jTextArea1.getText();

    return getPosition.length();
  }

  /**
   *
   * @return int
   */
  public int getEndOfText2()
  {
    String getPosition = jTextArea2.getText();

    return getPosition.length();
  }

  /** show actual time when copy action is starting */
  public void beginCopy()
  {
    jTextArea1.append("> " + new Date() + " ... kopieren der Dateien gestartet" + "\n");
    jTextArea1.append("" + "\n");
    jTextArea1.setCaretPosition(this.getEndOfText());
  }

  /** show actual time when copy action is ending */
  public void endCopy()
  {
    jTextArea1.append("" + "\n");
    jTextArea1.append("> " + new Date() + " ... kopieren der Dateien beendet" + "\n");
    jTextArea1.append("" + "\n");
    jTextArea1.setCaretPosition(getEndOfText());
  }

  /**
   * possibility to put information into the textarea (String textarea)
   *
   * @param setIn String
   */
  public void setInTextArea(String setIn)
  {
    jTextArea2.append("> " + setIn + "\n");
    jTextArea2.setCaretPosition(getEndOfText2());
  }

  /**
   * Auslesen des Textes
   *
   * @param eins_oder_zwei String
   *
   * @return String
   */
  public String getOutTextArea(String eins_oder_zwei)
  {

    String entscheidung = eins_oder_zwei;
    String returnArea1, returnArea2, returnTheString;

    returnTheString = "";

    if(entscheidung.equalsIgnoreCase("eins"))
    {
      returnArea1 = jTextArea1.getText();

      if(returnArea1 == null)
      {
        returnArea1 = " textarea leer, keine Sicherung erfolgt ";
      }

      returnTheString = returnArea1;
    }

    if(entscheidung.equalsIgnoreCase("zwei"))
    {
      returnArea2 = jTextArea2.getText();

      if(returnArea2 == null)
      {
        returnArea2 = " unerwarteter Fehler ! hier sollte keine Leerzeile möglich sein ";
      }

      returnTheString = returnArea2;
    }

    return returnTheString;

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
      jTextArea1.append("> " + new Date() + " ... löschen der markierten Dateien wird gestartet" + "\n");
      jTextArea1.append("" + "\n");

      String del = deletepath;

      this.deleteAllFiles(del);
      new File(del).delete();
      jTextArea1.append("> " + new Date() + " ... löschen der markierten Dateien beendet" + "\n");
      jTextArea1.append("" + "\n");
      jTextArea1.setCaretPosition(getEndOfText());
    }
    catch(Exception ex)
    {
      jTextArea2.append("> datum : " + new Date() + "\n" + "> Fehler aufgetreten : " + "\n" + "> " + ex + "\n");
      jTextArea2.setCaretPosition(getEndOfText2());
    }
  }

  /**
   * delete the files within the given path (String deletepath)
   * to delete the remaining directory use deleteAll(String deletepath)
   *
   * @param del String
   */
  public void deleteAllFiles(String del)
  {

    int  len           = del.length();
    File filesToDelete = new File(del);
    File arr[]         = filesToDelete.listFiles();

    for(int i = 0; i < arr.length; i++)
    {
      if(arr[i].isFile())
      {
        jTextArea1.append(arr[i].getPath() + "> ... wird gelöscht" + "\n");
        new File(arr[i].getPath()).delete();
        jTextArea1.setCaretPosition(getEndOfText());
      }

      if(arr[i].isDirectory())
      {
        directoryNames.add(arr[i].getPath());
        jTextArea1.append(arr[i].getPath() + "> ... wird gelöscht" + "\n");
        jTextArea1.setCaretPosition(getEndOfText());
        this.deleteAllFiles(arr[i].getPath());
        new File(arr[i].getPath()).delete();
      }
    }

  }

  /**
   */
  public void buttonState()
  {
    jButton1.setEnabled(true);
  }

  /** Main-Methode hier nicht erforderlich */

  /*
   * public static void main(String args[]) {
   *   new FileCopy().show();
   * }
   */
}


/* ||\
 * ---------------------------------------------------------
 */
