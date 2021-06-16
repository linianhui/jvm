package jvm.clazz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstantMethodRefTest extends AbstractTest {

    @Test
    void test_ConstantMethodRef() {
        Memory memory = newMemory(0x00, 0x10, 0x00, 0x11);
        ConstantMethodRef constant = new ConstantMethodRef(memory);
        Assertions.assertEquals(ConstantTag.MethodRef, constant.getTag());
        Assertions.assertEquals(16, constant.getClassIndex());
        Assertions.assertEquals(17, constant.getNameAndTypeIndex());
        Assertions.assertEquals(4, memory.getPosition());
    }
}