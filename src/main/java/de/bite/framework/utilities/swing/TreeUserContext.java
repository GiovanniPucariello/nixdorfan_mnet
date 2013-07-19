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

import java.util.Collection;
import java.util.HashMap;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class TreeUserContext
{
  //~--- fields ---------------------------------------------------------------

  HashMap< String, TreeUserObject > treeusers = new HashMap< String, TreeUserObject >();

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param name String
   * @param treeuser TreeUserObject
   */
  public void setTreeUserObject(String name, TreeUserObject treeuser)
  {
    this.treeusers.put(name, treeuser);
  }

  /**
   *
   * @param name String
   *
   * @return TreeUserObject
   */
  public TreeUserObject getTreeUserObject(String name)
  {
    return(TreeUserObject)this.treeusers.get(name);
  }

  /**
   *
   * @return Collection<TreeUserObject>
   */
  public Collection< TreeUserObject > getAllTreeUserObjects()
  {
    return this.treeusers.values();
  }
}


/* ||\
 * ---------------------------------------------------------
 */
