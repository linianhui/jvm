package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Memory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PackageConstantTest extends AbstractTest {

    @Test
    void test_ConstantPackage() {
        Memory memory = newMemory(0x00, 0x15);
        PackageConstant constant = new PackageConstant(null,memory);
        Assertions.assertEquals(Constant.Tag.Package, constant.getTag());
        Assertions.assertEquals(21, constant.getNameIndex());
        Assertions.assertEquals(2, memory.getPosition());
    }
}