package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Memory;
import jvm.clazz.constant.Constant;
import jvm.clazz.constant.ConstantModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstantModuleTest extends AbstractTest {

    @Test
    void test_ConstantModule() {
        Memory memory = newMemory(0x00, 0x15);
        ConstantModule constant = new ConstantModule(memory);
        Assertions.assertEquals(Constant.Tag.Module, constant.getTag());
        Assertions.assertEquals(21, constant.getNameIndex());
        Assertions.assertEquals(2, memory.getPosition());
    }
}