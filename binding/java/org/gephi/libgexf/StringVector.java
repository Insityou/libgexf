/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.gephi.libgexf;

public class StringVector {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected StringVector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(StringVector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libgexfJNI.delete_StringVector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public StringVector() {
    this(libgexfJNI.new_StringVector__SWIG_0(), true);
  }

  public StringVector(long n) {
    this(libgexfJNI.new_StringVector__SWIG_1(n), true);
  }

  public long size() {
    return libgexfJNI.StringVector_size(swigCPtr, this);
  }

  public long capacity() {
    return libgexfJNI.StringVector_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    libgexfJNI.StringVector_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return libgexfJNI.StringVector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    libgexfJNI.StringVector_clear(swigCPtr, this);
  }

  public void add(String x) {
    libgexfJNI.StringVector_add(swigCPtr, this, x);
  }

  public String get(int i) {
    return libgexfJNI.StringVector_get(swigCPtr, this, i);
  }

  public void set(int i, String val) {
    libgexfJNI.StringVector_set(swigCPtr, this, i, val);
  }

}
