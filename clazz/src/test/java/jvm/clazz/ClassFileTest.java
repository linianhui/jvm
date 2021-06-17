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
        Assertions.assertEquals("(D)V", ((ConstantUtf8) classFile.getConstantPool()[89]).getValue());

        Assertions.assertEquals(2, classFile.getAccessFlags().size());
        Assertions.assertTrue(classFile.getAccessFlags().contains(ClassAccessFlag.Public));
        Assertions.assertTrue(classFile.getAccessFlags().contains(ClassAccessFlag.Super));

        Assertions.assertEquals(5, classFile.getThisClass());
        Assertions.assertEquals(20, classFile.getSuperClass());

        Assertions.assertEquals(1, classFile.getInterfacesCount());
        Assertions.assertArrayEquals(new int[]{21}, classFile.getInterfaces());

        Assertions.assertEquals(9, classFile.getFieldsCount());
        Assertions.assertEquals(43,  classFile.getFields()[8].getNameIndex());

        Assertions.assertEquals(4, classFile.getMethodsCount());
        Assertions.assertEquals(53,  classFile.getMethods()[3].getNameIndex());
    }
}