package jvm.clazz;


import jvm.clazz.constant.UTF8Constant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClazzTest extends AbstractTest {

    @Test
    void test_ClassFile() {
        byte[] bytes = getResourceBytes("class_file_test.class");
        final Clazz clazz = new Clazz(new Memory(bytes));

        Assertions.assertEquals(0xCA_FE_BA_BE, clazz.getMagic());
        Assertions.assertEquals(0, clazz.getMinorVersion());
        Assertions.assertEquals(52, clazz.getMajorVersion());
        Assertions.assertEquals(90, clazz.getConstants().getCount());
        Assertions.assertEquals("(D)V", ((UTF8Constant) clazz.getConstants().getItems()[89]).getValue());

        Assertions.assertEquals(2, clazz.getAccessFlags().size());
        Assertions.assertTrue(clazz.getAccessFlags().contains(Clazz.AccessFlag.Public));
        Assertions.assertTrue(clazz.getAccessFlags().contains(Clazz.AccessFlag.Super));

        Assertions.assertEquals(5, clazz.getThisClass());
        Assertions.assertEquals(20, clazz.getSuperClass());

        Assertions.assertEquals(1, clazz.getInterfacesCount());
        Assertions.assertArrayEquals(new int[]{21}, clazz.getInterfaces());

        Assertions.assertEquals(9, clazz.getFieldsCount());
        Assertions.assertEquals(43, clazz.getFields()[8].getNameIndex());

        Assertions.assertEquals(4, clazz.getMethodsCount());
        Assertions.assertEquals(53, clazz.getMethods()[3].getNameIndex());

        Assertions.assertEquals(2, clazz.getAttributesCount());
        Assertions.assertEquals(58, clazz.getAttributes()[1].getNameIndex());
    }
}