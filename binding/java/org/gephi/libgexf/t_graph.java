/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.gephi.libgexf;

public final class t_graph {
  public final static t_graph GRAPH_DIRECTED = new t_graph("GRAPH_DIRECTED");
  public final static t_graph GRAPH_UNDIRECTED = new t_graph("GRAPH_UNDIRECTED");
  public final static t_graph GRAPH_MIXED = new t_graph("GRAPH_MIXED");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static t_graph swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + t_graph.class + " with value " + swigValue);
  }

  private t_graph(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private t_graph(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private t_graph(String swigName, t_graph swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static t_graph[] swigValues = { GRAPH_DIRECTED, GRAPH_UNDIRECTED, GRAPH_MIXED };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}
