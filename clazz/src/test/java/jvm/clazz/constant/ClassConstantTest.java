package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Memory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClassConstantTest extends AbstractTest {

    @Test
    void test_ConstantClass() {
        Memory memory = newMemory(0x00, 0x15);
        ClassConstant constant = new ClassConstant(memory);
        Assertions.assertEquals(Constant.Tag.Class, constant.getTag());
        Assertions.assertEquals(21, constant.getNameIndex());
        Assertions.assertEquals(2, memory.getPosition());
    }
}