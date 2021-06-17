package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Memory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MethodTypeConstantTest extends AbstractTest {

    @Test
    void test_ConstantMethodType() {
        Memory memory = newMemory(0x00, 0x15);
        MethodTypeConstant constant = new MethodTypeConstant(memory);
        Assertions.assertEquals(Constant.Tag.MethodRef, constant.getTag());
        Assertions.assertEquals(21, constant.getDescriptorIndex());
        Assertions.assertEquals(2, memory.getPosition());
    }
}