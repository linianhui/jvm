package jvm.clazz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstantMethodHandleTest extends AbstractTest {

    @Test
    void test_ConstantMethodHandle() {
        Memory memory = newMemory(0x02, 0x00, 0x13);
        ConstantMethodHandle constant = new ConstantMethodHandle(memory);
        Assertions.assertEquals(Constant.Tag.MethodHandle, constant.getTag());
        Assertions.assertEquals(ConstantMethodHandle.ReferenceKind.GetStatic, constant.getReferenceKind());
        Assertions.assertEquals(19, constant.getReferenceIndex());
        Assertions.assertEquals(3, memory.getPosition());
    }
}