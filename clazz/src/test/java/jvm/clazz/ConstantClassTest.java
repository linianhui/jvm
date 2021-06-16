package jvm.clazz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstantClassTest extends AbstractTest {

    @Test
    void test_ConstantClass() {
        Memory memory = newMemory(0x00, 0x15);
        ConstantClass constant_class = new ConstantClass(memory);
        Assertions.assertEquals(ConstantTag.Class, constant_class.getTag());
        Assertions.assertEquals(21, constant_class.getNameIndex());
        Assertions.assertEquals(2, memory.getPosition());
    }
}