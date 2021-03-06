/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.gephi.libgexf;

public class Conv {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected Conv(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Conv obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libgexfJNI.delete_Conv(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public static String xmlCharToId(SWIGTYPE_p_xmlChar str) {
    return libgexfJNI.Conv_xmlCharToId(SWIGTYPE_p_xmlChar.getCPtr(str));
  }

  public static String strToId(String str) {
    return libgexfJNI.Conv_strToId(str);
  }

  public static String xmlCharToStr(SWIGTYPE_p_xmlChar str) {
    return libgexfJNI.Conv_xmlCharToStr(SWIGTYPE_p_xmlChar.getCPtr(str));
  }

  public static long xmlCharToUnsignedInt(SWIGTYPE_p_xmlChar str) {
    return libgexfJNI.Conv_xmlCharToUnsignedInt(SWIGTYPE_p_xmlChar.getCPtr(str));
  }

  public static float xmlCharToFloat(SWIGTYPE_p_xmlChar str) {
    return libgexfJNI.Conv_xmlCharToFloat(SWIGTYPE_p_xmlChar.getCPtr(str));
  }

  public static String idToStr(String id) {
    return libgexfJNI.Conv_idToStr(id);
  }

  public static String unsignedIntToStr(long i) {
    return libgexfJNI.Conv_unsignedIntToStr(i);
  }

  public static String floatToStr(float f) {
    return libgexfJNI.Conv_floatToStr(f);
  }

  public static long strToUnsignedInt(String str) {
    return libgexfJNI.Conv_strToUnsignedInt(str);
  }

  public static String edgeTypeToStr(t_edge_type t) {
    return libgexfJNI.Conv_edgeTypeToStr(t.swigValue());
  }

  public static String attrTypeToStr(t_attr_type t) {
    return libgexfJNI.Conv_attrTypeToStr(t.swigValue());
  }

  public static boolean isBoolean(String str) {
    return libgexfJNI.Conv_isBoolean(str);
  }

  public static boolean isDouble(String str) {
    return libgexfJNI.Conv_isDouble(str);
  }

  public static boolean isInteger(String str) {
    return libgexfJNI.Conv_isInteger(str);
  }

  public static boolean isFloat(String str) {
    return libgexfJNI.Conv_isFloat(str);
  }

  public static boolean isLong(String str) {
    return libgexfJNI.Conv_isLong(str);
  }

  public static boolean isAnyURI(String str) {
    return libgexfJNI.Conv_isAnyURI(str);
  }

  public static SWIGTYPE_p_std__setT_std__string_t tokenizer(String delimiter, String str) {
    return new SWIGTYPE_p_std__setT_std__string_t(libgexfJNI.Conv_tokenizer(delimiter, str), true);
  }

}
