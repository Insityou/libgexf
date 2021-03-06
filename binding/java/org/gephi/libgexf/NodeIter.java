/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.gephi.libgexf;

public class NodeIter extends AbstractIter {
  private long swigCPtr;

  protected NodeIter(long cPtr, boolean cMemoryOwn) {
    super(libgexfJNI.SWIGNodeIterUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(NodeIter obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libgexfJNI.delete_NodeIter(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public NodeIter(Graph g) {
    this(libgexfJNI.new_NodeIter(Graph.getCPtr(g), g), true);
  }

  public AbstractIter begin() {
    long cPtr = libgexfJNI.NodeIter_begin(swigCPtr, this);
    return (cPtr == 0) ? null : new NodeIter(cPtr, false);
  }

}
