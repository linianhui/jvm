package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Bytes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DoubleConstantTest extends AbstractTest {

    @Test
    void test_ConstantDouble() {
        Bytes bytes = newBytes(0x40, 0x09, 0x21, 0xFB, 0x54, 0x44, 0x2D, 0x18);
        DoubleConstant constant = new DoubleConstant(null, bytes);
        Assertions.assertEquals(Constant.Tag.Double, constant.getTag());
        Assertions.assertEquals(3.1415_9265_3589_7932_3846D, constant.getValue());
        Assertions.assertEquals(8, bytes.getPosition());
    }
}