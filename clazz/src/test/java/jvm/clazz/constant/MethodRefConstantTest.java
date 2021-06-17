package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Memory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MethodRefConstantTest extends AbstractTest {

    @Test
    void test_ConstantMethodRef() {
        Memory memory = newMemory(0x00, 0x10, 0x00, 0x11);
        MethodRefConstant constant = new MethodRefConstant(null,memory);
        Assertions.assertEquals(Constant.Tag.MethodRef, constant.getTag());
        Assertions.assertEquals(16, constant.getClassIndex());
        Assertions.assertEquals(17, constant.getNameAndTypeIndex());
        Assertions.assertEquals(4, memory.getPosition());
    }
}