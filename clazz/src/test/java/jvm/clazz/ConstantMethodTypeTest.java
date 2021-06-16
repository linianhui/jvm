package jvm.clazz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstantMethodTypeTest extends AbstractTest {

    @Test
    void test_ConstantMethodType() {
        Memory memory = newMemory(0x00, 0x15);
        ConstantMethodType constant = new ConstantMethodType(memory);
        Assertions.assertEquals(ConstantTag.MethodRef, constant.getTag());
        Assertions.assertEquals(21, constant.getDescriptorIndex());
        Assertions.assertEquals(2, memory.getPosition());
    }
}