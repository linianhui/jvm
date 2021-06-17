package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Bytes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MethodTypeConstantTest extends AbstractTest {

    @Test
    void test_ConstantMethodType() {
        Bytes bytes = newBytes(0x00, 0x15);
        MethodTypeConstant constant = new MethodTypeConstant(null, bytes);
        Assertions.assertEquals(Constant.Tag.MethodRef, constant.getTag());
        Assertions.assertEquals(21, constant.getDescriptorIndex());
        Assertions.assertEquals(2, bytes.getPosition());
    }
}