package jvm.clazz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstantClassTest extends AbstractTest {

    @Test
    void test_ConstantClass() {
        Memory memory = newMemory(0x00, 0x15);
        ConstantClass constant = new ConstantClass(memory);
        Assertions.assertEquals(Constant.Tag.Class, constant.getTag());
        Assertions.assertEquals(21, constant.getNameIndex());
        Assertions.assertEquals(2, memory.getPosition());
    }
}