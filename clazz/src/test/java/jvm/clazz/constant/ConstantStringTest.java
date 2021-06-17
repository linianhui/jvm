package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Memory;
import jvm.clazz.constant.Constant;
import jvm.clazz.constant.ConstantString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstantStringTest extends AbstractTest {

    @Test
    void test_ConstantString() {
        Memory memory = newMemory(0x00, 0x15);
        ConstantString constant = new ConstantString(memory);
        Assertions.assertEquals(Constant.Tag.String, constant.getTag());
        Assertions.assertEquals(21, constant.getNameIndex());
        Assertions.assertEquals(2, memory.getPosition());
    }
}