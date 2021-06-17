package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Bytes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongConstantTest extends AbstractTest {

    @Test
    void test_ConstantLong() {
        Bytes bytes = newBytes(0x12, 0x34, 0x56, 0x78, 0x9A, 0xBC, 0xDE, 0xF0);
        LongConstant constant = new LongConstant(null, bytes);
        Assertions.assertEquals(Constant.Tag.Long, constant.getTag());
        Assertions.assertEquals(0x12_34_56_78_9A_BC_DE_F0L, constant.getValue());
        Assertions.assertEquals(8, bytes.getPosition());
    }
}