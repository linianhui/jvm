package jvm.clazz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstantIntegerTest extends AbstractTest {

    @Test
    void test_ConstantInteger() {
        Memory memory = newMemory(0x12, 0x34, 0x56, 0x78);
        ConstantInteger constant = new ConstantInteger(memory);
        Assertions.assertEquals(ConstantTag.Integer, constant.getTag());
        Assertions.assertEquals(0x12_34_56_78, constant.getValue());
        Assertions.assertEquals(4, memory.getPosition());
    }
}