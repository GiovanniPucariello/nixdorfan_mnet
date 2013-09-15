/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.utilities.swing.TreeUserContext.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
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
