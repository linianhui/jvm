package jvm.clazz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstantDoubleTest extends AbstractTest {

    @Test
    void test_ConstantDouble() {
        Memory memory = newMemory(0x40, 0x09, 0x21, 0xFB, 0x54, 0x44, 0x2D, 0x18);
        ConstantDouble constant = new ConstantDouble(memory);
        Assertions.assertEquals(Constant.Tag.Double, constant.getTag());
        Assertions.assertEquals(3.1415_9265_3589_7932_3846D, constant.getValue());
        Assertions.assertEquals(8, memory.getPosition());
    }
}