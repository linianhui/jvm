package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Memory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongConstantTest extends AbstractTest {

    @Test
    void test_ConstantLong() {
        Memory memory = newMemory(0x12, 0x34, 0x56, 0x78, 0x9A, 0xBC, 0xDE, 0xF0);
        LongConstant constant = new LongConstant(memory);
        Assertions.assertEquals(Constant.Tag.Long, constant.getTag());
        Assertions.assertEquals(0x12_34_56_78_9A_BC_DE_F0L, constant.getValue());
        Assertions.assertEquals(8, memory.getPosition());
    }
}