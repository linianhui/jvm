package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Memory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringConstantTest extends AbstractTest {

    @Test
    void test_ConstantString() {
        Memory memory = newMemory(0x00, 0x15);
        StringConstant constant = new StringConstant(memory);
        Assertions.assertEquals(Constant.Tag.String, constant.getTag());
        Assertions.assertEquals(21, constant.getNameIndex());
        Assertions.assertEquals(2, memory.getPosition());
    }
}