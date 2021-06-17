package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Memory;
import jvm.clazz.constant.Constant;
import jvm.clazz.constant.ConstantUtf8;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstantUtf8Test extends AbstractTest {

    @Test
    void test_ConstantUtf8() {
        Memory memory = newMemory(0x00, 0x06, 0x3C, 0x69, 0x6E, 0x69, 0x74, 0x3E);
        ConstantUtf8 constant = new ConstantUtf8(memory);
        Assertions.assertEquals(Constant.Tag.Utf8, constant.getTag());
        Assertions.assertEquals("<init>", constant.getValue());
        Assertions.assertEquals(8, memory.getPosition());
    }
}