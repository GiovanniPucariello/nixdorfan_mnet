/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.utilities.swing.components.BiteSkeletonFrame.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

package de.bite.framework.utilities.swing.components;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.utilities.swing.status.Be;
import de.bite.framework.utilities.swing.status.JStatusLeiste;

//~--- JDK imports ------------------------------------------------------------

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class BiteSkeletonFrame extends JFrame
{

  //~--- fields ---------------------------------------------------------------

//-------------------------------------------------------------------------------------------------------
// MEMBERVARIABLEN
  private Container                 contentPane = getContentPane();
  private JStatusLeiste             JsL         = new JStatusLeiste(new BorderLayout());
  private Component[]               cAry;
  private JPanel                    centralPanel = new JPanel();
  private FrameKonfigurationBuilder builder;

  //~--- constructors ---------------------------------------------------------

//-------------------------------------------------------------------------------------------------------
//  KONSTRUKTOREN
  // Konstruktor des "JFensters" mit Konstruktormethoden

  /**
   *
   * @param builder FrameKonfigurationBuilder
   */
  public BiteSkeletonFrame(FrameKonfigurationBuilder builder)
  {
    this.builder = builder;

    // init Frame Parameter
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setTitle(builder.getFontFrame());
    this.setFont(new Font(builder.getFontNameFrame(), Font.PLAIN, builder.getFontSizeFrame()));
    this.setLocation(550, 50);
    this.setSize(builder.getHeightFrame(), builder.getWidthFrame());
    this.setBackground(Color.lightGray);
    this.setVisible(true);
    contentPane.add(this.centralPanel, BorderLayout.CENTER);
    contentPane.add(JsL, BorderLayout.SOUTH);
  }




  //~--- methods --------------------------------------------------------------

//-------------------------------------------------------------------------------------------------------
//  METHODEN
//  Kontruktormethoden(1)

  /**
   *
   * @param height int
   * @param width int
   */
  public void setSize(int height, int width) {}

  /**
   *
   * @param panel JPanel
   */
  public void addPanel(JPanel panel) {}

//-------------------------------------------------------------------------------------------------------
//  HAUPTMETHODE

  /**
   *
   * @param args String[]
   */
  public static void main(String[] args)
  {
    BiteSkeletonFrame fs = new BiteSkeletonFrame(new FrameKonfigurationBuilder());
  }    // end main
}


/* ||\
 * ---------------------------------------------------------
 */