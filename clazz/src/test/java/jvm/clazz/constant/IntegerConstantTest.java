package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Bytes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegerConstantTest extends AbstractTest {

    @Test
    void test_ConstantInteger() {
        Bytes bytes = newBytes(0x12, 0x34, 0x56, 0x78);
        IntegerConstant constant = new IntegerConstant(null, bytes);
        Assertions.assertEquals(Constant.Tag.Integer, constant.getTag());
        Assertions.assertEquals(0x12_34_56_78, constant.getValue());
        Assertions.assertEquals(4, bytes.getPosition());
    }
}