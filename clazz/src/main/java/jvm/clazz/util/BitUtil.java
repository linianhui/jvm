package jvm.clazz.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class BitUtil {
    public static Set<Integer> in(final Collection<Integer> list, int value) {
        final Set<Integer> set = new HashSet<>();
        if (list != null) {
            for (Integer i : list) {
                if ((value & i) != 0) {
                    set.add(i);
                }
            }
        }
        return set;
    }
}
