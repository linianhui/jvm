package jvm.clazz;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClassFileTest extends AbstractTest {

    @Test
    void test_ClassFile() {
        byte[] bytes = getResourceBytes("class_file_test.class");
        final ClassFile classFile = new ClassFile(new Memory(bytes));

        Assertions.assertEquals(0xCA_FE_BA_BE, classFile.getMagic());
        Assertions.assertEquals(0, classFile.getMinorVersion());
        Assertions.assertEquals(52, classFile.getMajorVersion());
        Assertions.assertEquals(90, classFile.getConstantPoolCount());
    }
}