package jvm.clazz.util;

import java.util.Set;

import jvm.clazz.Clazz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BitUtilTest {

    @Test
    void test_in_when_list_is_null_should_return_empty_set() {
        Assertions.assertEquals(0, BitUtil.in(null, 1).size());
    }

    @Test
    void test_in_ok() {
        Set<Clazz.AccessFlag> set = BitUtil.in(Clazz.AccessFlag.class, 1);
        Assertions.assertEquals(1, set.size());
        Assertions.assertEquals(Set.of(Clazz.AccessFlag.Public), set);
    }
}