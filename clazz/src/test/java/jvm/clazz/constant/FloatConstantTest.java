package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Memory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FloatConstantTest extends AbstractTest {

    @Test
    void test_ConstantFloat() {
        Memory memory = newMemory(0x40, 0x49, 0x0F, 0xDB);
        FloatConstant constant = new FloatConstant(null,memory);
        Assertions.assertEquals(Constant.Tag.Float, constant.getTag());
        Assertions.assertEquals(3.14159265f, constant.getValue());
        Assertions.assertEquals(4, memory.getPosition());
    }
}