package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Bytes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FloatConstantTest extends AbstractTest {

    @Test
    void test_ConstantFloat() {
        Bytes bytes = newBytes(0x40, 0x49, 0x0F, 0xDB);
        FloatConstant constant = new FloatConstant(null, bytes);
        Assertions.assertEquals(Constant.Tag.Float, constant.getTag());
        Assertions.assertEquals(3.14159265f, constant.getValue());
        Assertions.assertEquals(4, bytes.getPosition());
    }
}