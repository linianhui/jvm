package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Bytes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringConstantTest extends AbstractTest {

    @Test
    void test_ConstantString() {
        Bytes bytes = newBytes(0x00, 0x15);
        StringConstant constant = new StringConstant(null, bytes);
        Assertions.assertEquals(Constant.Tag.String, constant.getTag());
        Assertions.assertEquals(21, constant.getNameIndex());
        Assertions.assertEquals(2, bytes.getPosition());
    }
}