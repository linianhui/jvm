package jvm.clazz.constant;

import jvm.clazz.AbstractTest;
import jvm.clazz.Bytes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PackageConstantTest extends AbstractTest {

    @Test
    void test_ConstantPackage() {
        Bytes bytes = newBytes(0x00, 0x15);
        PackageConstant constant = new PackageConstant(null, bytes);
        Assertions.assertEquals(Constant.Tag.Package, constant.getTag());
        Assertions.assertEquals(21, constant.getNameIndex());
        Assertions.assertEquals(2, bytes.getPosition());
    }
}