package jvm.clazz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstantModuleTest extends AbstractTest {

    @Test
    void test_ConstantModule() {
        Memory memory = newMemory(0x00, 0x15);
        ConstantModule constant = new ConstantModule(memory);
        Assertions.assertEquals(ConstantTag.Module, constant.getTag());
        Assertions.assertEquals(21, constant.getNameIndex());
        Assertions.assertEquals(2, memory.getPosition());
    }
}