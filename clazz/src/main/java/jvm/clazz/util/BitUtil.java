package jvm.clazz.util;

import java.util.HashSet;
import java.util.Set;

import jvm.clazz.Bit;

public class BitUtil {
    public static <E extends Enum<E> & Bit> Set<E> from(final Class<E> eClass, int value) {
        final Set<E> set = new HashSet<>();
        if (eClass!=null) {
            E[] items = eClass.getEnumConstants();
            for (E item : items) {
                if ((value & item.raw())!=0) {
                    set.add(item);
                }
            }
        }
        return set;
    }
}
