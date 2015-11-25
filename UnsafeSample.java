package com.drm.main;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class UnsafeSample {
  public void methodWithNoDeclaredExceptions() {
    Unsafe unsafe = getUnsafe();
    unsafe.throwException(new Exception("this should be checked"));
  }

  private Unsafe getUnsafe() {
    try {
      Field field = Unsafe.class.getDeclaredField("theUnsafe");
      field.setAccessible(true);
      return (Unsafe) field.get(null);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    new UnsafeSample().methodWithNoDeclaredExceptions();
  }
}
