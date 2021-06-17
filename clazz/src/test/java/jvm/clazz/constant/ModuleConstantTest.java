package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Bytes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ModuleConstantTest extends AbstractTest {

    @Test
    void test_ConstantModule() {
        Bytes bytes = newBytes(0x00, 0x15);
        ModuleConstant constant = new ModuleConstant(null, bytes);
        Assertions.assertEquals(Constant.Tag.Module, constant.getTag());
        Assertions.assertEquals(21, constant.getNameIndex());
        Assertions.assertEquals(2, bytes.getPosition());
    }
}