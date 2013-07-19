/**
 *
 * Copyright (c) 2013.06.15
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0-b147
 * 
 */

package de.bite.framework.utilities.swing.components;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class FrameKonfigurationBuilder
{

  //~--- fields ---------------------------------------------------------------

  String fontFrame     = "Skeleton";
  String fontNameFrame = "Courier";
  int    fontSizeFrame = 12;
  int    heightFrame   = 1000;
  int    widthFrame    = 768;

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @return String
   */
  public String getFontNameFrame()
  {
    return fontNameFrame;
  }

  /**
   * 
   * @param fontNameFrame String
   */
  public void setFontNameFrame(String fontNameFrame)
  {
    this.fontNameFrame = fontNameFrame;
  }

  /**
   *
   * @return String
   */
  public String getFontFrame()
  {
    return fontFrame;
  }

  /**
   *
   * @param fontFrame String
   */
  public void setFontFrame(String fontFrame)
  {
    this.fontFrame = fontFrame;
  }

  /**
   *
   * @return int
   */
  public int getFontSizeFrame()
  {
    return fontSizeFrame;
  }

  /**
   *
   * @param fontSizeFrame int
   */
  public void setFontSizeFrame(int fontSizeFrame)
  {
    this.fontSizeFrame = fontSizeFrame;
  }

  /**
   *
   * @return int
   */
  public int getHeightFrame()
  {
    return heightFrame;
  }

  /**
   *
   * @param heightFrame int
   */
  public void setHeightFrame(int heightFrame)
  {
    this.heightFrame = heightFrame;
  }

  /**
   *
   * @return int
   */
  public int getWidthFrame()
  {
    return widthFrame;
  }

  /**
   *
   * @param widthFrame int
   */
  public void setWidthFrame(int widthFrame)
  {
    this.widthFrame = widthFrame;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
