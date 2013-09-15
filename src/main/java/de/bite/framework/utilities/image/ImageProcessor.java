/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.utilities.image.ImageProcessor.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

/*
* @(#)ImageProcessor.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.image;

//~--- non-JDK imports --------------------------------------------------------

import de.bite.framework.constants.Constants;

import org.apache.log4j.Logger;

//~--- JDK imports ------------------------------------------------------------

import java.awt.geom.AffineTransform;
import java.awt.Image;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class ImageProcessor
{

  //~--- static fields --------------------------------------------------------

  private static Logger logger = Logger.getLogger(ImageProcessor.class);

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param x double
   * @param y double
   * @param interpolationtype int
   * @param imageFile File
   * @param imagepostfix String
   * @param miniaturname String
   * @param newPath String
   *
   * @return boolean
   */
  public static boolean createThumbnailImage(double x, double y, int interpolationtype, File imageFile, String imagepostfix, String miniaturname, String newPath)
  {

    // default interpolationtype
    if(interpolationtype == 0)
    {
      interpolationtype = 1;
    }

    // default image postfix
    if(imagepostfix == null)
    {
      imagepostfix = "jpeg";
    }

    /**
     * Possible interpolation-types
     *
     *  TYPE_NEAREST_NEIGHBOR = 1;
     *          TYPE_BILINEAR = 2;
     *          TYPE_BICUBIC = 3;
     */
    try
    {
      BufferedImage     img         = ImageIO.read(imageFile);
      AffineTransform   transform   = AffineTransform.getScaleInstance(x, y);
      AffineTransformOp op          = new AffineTransformOp(transform, interpolationtype);
      BufferedImage     scaledImage = op.filter(img, null);

      ImageIO.write(scaledImage, imagepostfix, new File(newPath + miniaturname + "_" + imageFile.getName()));
      logger.info(Constants.info_message + " Bild neu berechnet ==  " + newPath + miniaturname + "_" + imageFile.getName());

      return true;
    }
    catch(IOException e)
    {
      logger.error(Constants.error_message + " Bildberechnung fehlerhaft == " + imageFile.getAbsolutePath());

      return false;
    }
  }

  /**
   *
   * @param x double
   * @param y double
   * @param interpolationtype int
   * @param imageFile File
   * @param imagepostfix String
   * @param miniaturname String
   * @param newPath String
   *
   * @return Image
   */
  public static Image returnThumbnailImage(double x, double y, int interpolationtype, File imageFile, String imagepostfix, String miniaturname, String newPath)
  {

    // default interpolationtype
    if(interpolationtype == 0)
    {
      interpolationtype = 1;
    }

    // default image postfix
    if(imagepostfix == null)
    {
      imagepostfix = "jpeg";
    }

    /**
     * Possible interpolation-types
     *
     *  TYPE_NEAREST_NEIGHBOR = 1;
     *          TYPE_BILINEAR = 2;
     *          TYPE_BICUBIC = 3;
     */
    try
    {
      BufferedImage     img         = ImageIO.read(imageFile);
      AffineTransform   transform   = AffineTransform.getScaleInstance(x, y);
      AffineTransformOp op          = new AffineTransformOp(transform, interpolationtype);
      BufferedImage     scaledImage = op.filter(img, null);

      // ImageIO.write(scaledImage, imagepostfix, new File(newPath + miniaturname + "_" + imageFile.getName()));
      logger.info(Constants.info_message + " Bild neu berechnet ==  " + newPath + miniaturname + "_" + imageFile.getName());

      return scaledImage;
    }
    catch(IOException e)
    {
      logger.error(Constants.error_message + " Bildberechnung fehlerhaft == " + imageFile.getAbsolutePath());

      return null;
    }
  }
}


/* ||\
 * ---------------------------------------------------------
 */
