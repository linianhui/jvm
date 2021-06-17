package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Bytes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DynamicConstantTest extends AbstractTest {

    @Test
    void test_ConstantDynamic() {
        Bytes bytes = newBytes(0x00, 0x12, 0x00, 0x13);
        DynamicConstant constant = new DynamicConstant(null, bytes);
        Assertions.assertEquals(Constant.Tag.Dynamic, constant.getTag());
        Assertions.assertEquals(18, constant.getBootstrapMethodAttributeIndex());
        Assertions.assertEquals(19, constant.getNameAndTypeIndex());
        Assertions.assertEquals(4, bytes.getPosition());
    }
}