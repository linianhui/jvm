package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Memory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InvokeDynamicConstantTest extends AbstractTest {

    @Test
    void test_ConstantInvokeDynamic() {
        Memory memory = newMemory(0x00, 0x12, 0x00, 0x13);
        InvokeDynamicConstant constant = new InvokeDynamicConstant(null,memory);
        Assertions.assertEquals(Constant.Tag.InvokeDynamic, constant.getTag());
        Assertions.assertEquals(18, constant.getBootstrapMethodAttributeIndex());
        Assertions.assertEquals(19, constant.getNameAndTypeIndex());
        Assertions.assertEquals(4, memory.getPosition());
    }
}