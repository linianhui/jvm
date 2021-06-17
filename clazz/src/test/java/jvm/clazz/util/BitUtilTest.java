package jvm.clazz.util;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BitUtilTest {

    @Test
    void test_in_when_list_is_null_should_return_empty_set() {
        Assertions.assertEquals(0, BitUtil.in(null, 1).size());
    }

    @Test
    void test_in_ok() {
        Set<Integer> set = BitUtil.in(List.of(1, 2, 4, 8), 7);
        Assertions.assertEquals(3, set.size());
        Assertions.assertEquals(Set.of(1, 2, 4), set);
    }
}