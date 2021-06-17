package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Bytes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MethodRefConstantTest extends AbstractTest {

    @Test
    void test_ConstantMethodRef() {
        Bytes bytes = newBytes(0x00, 0x10, 0x00, 0x11);
        MethodRefConstant constant = new MethodRefConstant(null, bytes);
        Assertions.assertEquals(Constant.Tag.MethodRef, constant.getTag());
        Assertions.assertEquals(16, constant.getClassIndex());
        Assertions.assertEquals(17, constant.getNameAndTypeIndex());
        Assertions.assertEquals(4, bytes.getPosition());
    }
}