package jvm.clazz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstantNameAndTypeTest extends AbstractTest {

    @Test
    void test_ConstantNameAndType() {
        Memory memory = newMemory(0x00, 0x10, 0x00, 0x11);
        ConstantNameAndType constant = new ConstantNameAndType(memory);
        Assertions.assertEquals(Constant.Tag.MethodRef, constant.getTag());
        Assertions.assertEquals(16, constant.getNameIndex());
        Assertions.assertEquals(17, constant.getDescriptorIndex());
        Assertions.assertEquals(4, memory.getPosition());
    }
}