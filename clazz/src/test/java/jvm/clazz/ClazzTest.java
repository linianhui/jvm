package jvm.clazz;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClazzTest extends AbstractTest {

    @Test
    void test_ClassFile() {
        byte[] bytes = getResourceBytes("class_file_test.class");
        final Clazz clazz = new Clazz(new Bytes(bytes));

        Assertions.assertEquals(0xCA_FE_BA_BE, clazz.getMagic());
        Assertions.assertEquals(0, clazz.getMinorVersion());
        Assertions.assertEquals(52, clazz.getMajorVersion());
        Assertions.assertEquals(90, clazz.getConstants().getCount());
        Assertions.assertEquals("(D)V", clazz.getConstants().getUTF8String(89));

        Assertions.assertEquals(2, clazz.getAccessFlags().size());
        Assertions.assertTrue(clazz.getAccessFlags().contains(Clazz.AccessFlag.Public));
        Assertions.assertTrue(clazz.getAccessFlags().contains(Clazz.AccessFlag.Super));

        Assertions.assertEquals(5, clazz.getThisClass());
        Assertions.assertEquals("class_file_test", clazz.getThisClassString());
        Assertions.assertEquals(20, clazz.getSuperClass());
        Assertions.assertEquals("java/lang/Object", clazz.getSuperClassString());

        Assertions.assertEquals(1, clazz.getInterfaces().getCount());
        Assertions.assertEquals(21, clazz.getInterfaces().get(0));

        Assertions.assertEquals(9, clazz.getFields().getCount());
        Assertions.assertEquals(43, clazz.getFields().get(8).getNameIndex());

        Assertions.assertEquals(4, clazz.getMethods().getCount());
        Assertions.assertEquals(53, clazz.getMethods().get(3).getNameIndex());

        Assertions.assertEquals(2, clazz.getAttributes().getCount());
        Assertions.assertEquals(58, clazz.getAttributes().get(1).getNameIndex());
        Assertions.assertEquals("SourceFile", clazz.getAttributes().get(1).getName());
    }

    @Test
    void test_ClassFile_List() {
        List<byte[]> classFileBytesList = findClassFileBytesList();
        for (byte[] bytes : classFileBytesList) {
            Clazz clazz = new Clazz(new Bytes(bytes));
            Assertions.assertNotNull(clazz);
        }
    }
}