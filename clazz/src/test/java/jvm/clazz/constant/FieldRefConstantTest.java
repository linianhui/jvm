package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Bytes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FieldRefConstantTest extends AbstractTest {

    @Test
    void test_ConstantFieldRef() {
        Bytes bytes = newBytes(0x00, 0x10, 0x00, 0x11);
        FieldRefConstant constant = new FieldRefConstant(null, bytes);
        Assertions.assertEquals(Constant.Tag.FieldRef, constant.getTag());
        Assertions.assertEquals(16, constant.getClassIndex());
        Assertions.assertEquals(17, constant.getNameAndTypeIndex());
        Assertions.assertEquals(4, bytes.getPosition());
    }
}