/**
 *
 * Copyright (c) 2013.06.14
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0-b147
 * 
 */

package de.bite.framework.utilities.swing;

//~--- JDK imports ------------------------------------------------------------

import javax.swing.ImageIcon;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class TreeUserObject
{

  //~--- fields ---------------------------------------------------------------

  private String    comment;
  private boolean   isActive;
  private String    linkName;
  private String    multimediaType;
  private String    name;
  private String    path;
  private String    type;
  private String    category;
  private ImageIcon image;
  private int       nodeIndex = 0;

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @return String
   */
  public String getCategory()
  {
    return category;
  }

  /**
   * 
   * @param category String
   */
  public void setCategory(String category)
  {
    this.category = category;
  }

  /**
   *
   * @return int
   */
  public int getNodeIndex()
  {
    return nodeIndex;
  }

  /**
   *
   * @param nodeIndex int
   */
  public void setNodeIndex(int nodeIndex)
  {
    this.nodeIndex = nodeIndex;
  }

  /**
   *
   * @return ImageIcon
   */
  public ImageIcon getImage()
  {
    return image;
  }

  /**
   *
   * @param image ImageIcon
   */
  public void setImage(ImageIcon image)
  {
    this.image = image;
  }

  /**
   *
   * @return String
   */
  public String getMultimediaType()
  {
    return multimediaType;
  }

  /**
   *
   * @param multimediaType String
   */
  public void setMultimediaType(String multimediaType)
  {
    this.multimediaType = multimediaType;
  }

  /**
   *
   * @return String
   */
  public String getComment()
  {
    return comment;
  }

  /**
   *
   * @param comment String
   */
  public void setComment(String comment)
  {
    this.comment = comment;
  }

  /**
   *
   * @return boolean
   */
  public boolean isIsActive()
  {
    return isActive;
  }

  /**
   *
   * @param isActive boolean
   */
  public void setIsActive(boolean isActive)
  {
    this.isActive = isActive;
  }

  /**
   *
   * @return String
   */
  public String getLinkName()
  {
    return linkName;
  }

  /**
   *
   * @param linkName String
   */
  public void setLinkName(String linkName)
  {
    this.linkName = linkName;
  }

  /**
   *
   * @return String
   */
  public String getType()
  {
    return this.type;
  }

  /**
   *
   * @param type String
   */
  public void setType(String type)
  {
    this.type = type;
  }

  /**
   *
   * @return String
   */
  public String getName()
  {
    return name;
  }

  /**
   *
   * @param name String
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   *
   * @return String
   */
  public String getPath()
  {
    return path;
  }

  /**
   *
   * @param path String
   */
  public void setPath(String path)
  {
    this.path = path;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
