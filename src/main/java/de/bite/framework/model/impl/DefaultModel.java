/*
 * ||
 * netbeans 201306052037 | 1.23
 * Java(TM) SE Runtime Environment 1.7.0_25-b15 (mixed mode little endian)
 * de.bite.framework.model.impl.DefaultModel.java 1.0 | 2013.09.14 bas | UTF8 | tab 2
 */

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package de.bite.framework.model.impl;

//~--- JDK imports ------------------------------------------------------------

import java.util.HashMap;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author nixdorfan
 */
public class DefaultModel extends AbstractModel
{

  //~--- fields ---------------------------------------------------------------

  public String                    actualState  = "";
  public String                    actualValue  = "";
  public HashMap< String, String > processState = new HashMap< String, String >();

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param name String
   * @param value String
   */
  @Override
  public void setProcessingState(String name, String value)
  {
    this.processState.put(name, value);

    this.actualState = name;
    this.actualValue = value;
  }

  /**
   *
   * @return String
   */
  @Override
  public String getProcessingStateName()
  {
    return this.actualState;
  }

  /**
   *
   * @return String
   */
  @Override
  public String getProcessingStateValue()
  {
    return this.actualValue;
  }

  /**
   *
   * @return HashMap<String,Object>
   */
  @Override
  public HashMap< String, Object > getAllData()
  {
    return this.data;
  }

  /**
   *
   * @return HashMap<String,String>
   */
  @Override
  public HashMap< String, String > getStatesAndValues()
  {
    return this.processState;
  }
}


/* ||\
 * ---------------------------------------------------------
 */
