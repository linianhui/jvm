package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Memory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MethodHandleConstantTest extends AbstractTest {

    @Test
    void test_ConstantMethodHandle() {
        Memory memory = newMemory(0x02, 0x00, 0x13);
        MethodHandleConstant constant = new MethodHandleConstant(memory);
        Assertions.assertEquals(Constant.Tag.MethodHandle, constant.getTag());
        Assertions.assertEquals(MethodHandleConstant.ReferenceKind.GetStatic, constant.getReferenceKind());
        Assertions.assertEquals(19, constant.getReferenceIndex());
        Assertions.assertEquals(3, memory.getPosition());
    }
}