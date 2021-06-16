package jvm.clazz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstantFloatTest extends AbstractTest {

    @Test
    void test_ConstantFloat() {
        Memory memory = newMemory(0x40, 0x49, 0x0F, 0xDB);
        ConstantFloat constant = new ConstantFloat(memory);
        Assertions.assertEquals(ConstantTag.Float, constant.getTag());
        Assertions.assertEquals(3.14159265f, constant.getValue());
        Assertions.assertEquals(4, memory.getPosition());
    }
}