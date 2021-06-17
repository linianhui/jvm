package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Memory;
import jvm.clazz.constant.Constant;
import jvm.clazz.constant.ConstantInterfaceMethodRef;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstantInterfaceMethodRefTest extends AbstractTest {

    @Test
    void test_ConstantInterfaceMethodRef() {
        Memory memory = newMemory(0x00, 0x10, 0x00, 0x11);
        ConstantInterfaceMethodRef constant = new ConstantInterfaceMethodRef(memory);
        Assertions.assertEquals(Constant.Tag.InterfaceMethodRef, constant.getTag());
        Assertions.assertEquals(16, constant.getClassIndex());
        Assertions.assertEquals(17, constant.getNameAndTypeIndex());
        Assertions.assertEquals(4, memory.getPosition());
    }
}