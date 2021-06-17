package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Memory;
import jvm.clazz.constant.Constant;
import jvm.clazz.constant.ConstantLong;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstantLongTest extends AbstractTest {

    @Test
    void test_ConstantLong() {
        Memory memory = newMemory(0x12, 0x34, 0x56, 0x78, 0x9A, 0xBC, 0xDE, 0xF0);
        ConstantLong constant = new ConstantLong(memory);
        Assertions.assertEquals(Constant.Tag.Long, constant.getTag());
        Assertions.assertEquals(0x12_34_56_78_9A_BC_DE_F0L, constant.getValue());
        Assertions.assertEquals(8, memory.getPosition());
    }
}