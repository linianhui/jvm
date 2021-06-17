package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Bytes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MethodHandleConstantTest extends AbstractTest {

    @Test
    void test_ConstantMethodHandle() {
        Bytes bytes = newBytes(0x02, 0x00, 0x13);
        MethodHandleConstant constant = new MethodHandleConstant(null, bytes);
        Assertions.assertEquals(Constant.Tag.MethodHandle, constant.getTag());
        Assertions.assertEquals(MethodHandleConstant.ReferenceKind.GetStatic, constant.getReferenceKind());
        Assertions.assertEquals(19, constant.getReferenceIndex());
        Assertions.assertEquals(3, bytes.getPosition());
    }
}