package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Memory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ModuleConstantTest extends AbstractTest {

    @Test
    void test_ConstantModule() {
        Memory memory = newMemory(0x00, 0x15);
        ModuleConstant constant = new ModuleConstant(memory);
        Assertions.assertEquals(Constant.Tag.Module, constant.getTag());
        Assertions.assertEquals(21, constant.getNameIndex());
        Assertions.assertEquals(2, memory.getPosition());
    }
}