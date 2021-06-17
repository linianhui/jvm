package jvm.clazz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstantDynamicTest extends AbstractTest {

    @Test
    void test_ConstantDynamic() {
        Memory memory = newMemory(0x00, 0x12, 0x00, 0x13);
        ConstantDynamic constant = new ConstantDynamic(memory);
        Assertions.assertEquals(Constant.Tag.Dynamic, constant.getTag());
        Assertions.assertEquals(18, constant.getBootstrapMethodAttributeIndex());
        Assertions.assertEquals(19, constant.getNameAndTypeIndex());
        Assertions.assertEquals(4, memory.getPosition());
    }
}