package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Bytes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InterfaceMethodRefConstantTest extends AbstractTest {

    @Test
    void test_ConstantInterfaceMethodRef() {
        Bytes bytes = newBytes(0x00, 0x10, 0x00, 0x11);
        InterfaceMethodRefConstant constant = new InterfaceMethodRefConstant(null, bytes);
        Assertions.assertEquals(Constant.Tag.InterfaceMethodRef, constant.getTag());
        Assertions.assertEquals(16, constant.getClassIndex());
        Assertions.assertEquals(17, constant.getNameAndTypeIndex());
        Assertions.assertEquals(4, bytes.getPosition());
    }
}