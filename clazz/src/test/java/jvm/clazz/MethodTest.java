package jvm.clazz;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MethodTest extends AbstractTest {

    @Test
    void test_Method() {
        Memory memory = newMemory(
            0x00, 0x01, 0x00, 0x2D, 0x00, 0x2E, 0x00, 0x01, 0x00, 0x2F, 0x00, 0x00, 0x00, 0x1D, 0x00,
            0x01, 0x00, 0x01, 0x00, 0x00, 0x00, 0x05, 0x2A, 0xB7, 0x00, 0x01, 0xB1, 0x00, 0x00, 0x00,
            0x01, 0x00, 0x30, 0x00, 0x00, 0x00, 0x06, 0x00, 0x01, 0x00, 0x00, 0x00, 0x03, 0x00, 0x09,
            0x00, 0x31, 0x00, 0x32, 0x00, 0x02, 0x00, 0x2F, 0x00, 0x00, 0x00, 0x93, 0x00, 0x03, 0x00,
            0x01, 0x00, 0x00, 0x00, 0x53, 0xB2, 0x00, 0x02, 0x12, 0x03, 0xB6, 0x00, 0x04, 0xB2, 0x00,
            0x02, 0x04, 0xB6, 0x00, 0x06, 0xB2, 0x00, 0x02, 0x10, 0x20, 0xB6, 0x00, 0x07, 0xB2, 0x00,
            0x02, 0x10, 0x4C, 0xB6, 0x00, 0x08, 0xB2, 0x00, 0x02, 0x12, 0x09, 0xB6, 0x00, 0x04, 0xB2,
            0x00, 0x02, 0x11, 0x30, 0x39, 0xB6, 0x00, 0x07, 0xB2, 0x00, 0x02, 0x12, 0x0A, 0xB6, 0x00,
            0x07, 0xB2, 0x00, 0x02, 0x14, 0x00, 0x0B, 0xB6, 0x00, 0x0D, 0xB2, 0x00, 0x02, 0x12, 0x0E,
            0xB6, 0x00, 0x0F, 0xB2, 0x00, 0x02, 0x14, 0x00, 0x10, 0xB6, 0x00, 0x12, 0xB1, 0x00, 0x00,
            0x00, 0x01, 0x00, 0x30, 0x00, 0x00, 0x00, 0x2E, 0x00, 0x0B, 0x00, 0x00, 0x00, 0x0F, 0x00,
            0x08, 0x00, 0x10, 0x00, 0x0F, 0x00, 0x11, 0x00, 0x17, 0x00, 0x12, 0x00, 0x1F, 0x00, 0x13,
            0x00, 0x27, 0x00, 0x14, 0x00, 0x30, 0x00, 0x15, 0x00, 0x38, 0x00, 0x16, 0x00, 0x41, 0x00,
            0x17, 0x00, 0x49, 0x00, 0x18, 0x00, 0x52, 0x00, 0x19, 0x00, 0x33, 0x00, 0x00, 0x00, 0x04,
            0x00, 0x01, 0x00, 0x34
        );
        Methods methods = Methods.from(null, memory, 2);

        Assertions.assertEquals(2, methods.getCount());

        Assertions.assertEquals(1, methods.get(0).getAccessFlags().size());
        Assertions.assertTrue(methods.get(0).getAccessFlags().contains(Field.AccessFlag.Public));
        Assertions.assertEquals(45, methods.get(0).getNameIndex());
        Assertions.assertEquals(46, methods.get(0).getDescriptorIndex());
        Assertions.assertEquals(1, methods.get(0).getAttributes().getCount());
        Assertions.assertEquals(47, methods.get(0).getAttributes().get(0).getNameIndex());
        Assertions.assertEquals(29, methods.get(0).getAttributes().get(0).getLength());

        Assertions.assertEquals(2, methods.get(1).getAccessFlags().size());
        Assertions.assertTrue(methods.get(1).getAccessFlags().contains(Field.AccessFlag.Public));
        Assertions.assertTrue(methods.get(1).getAccessFlags().contains(Field.AccessFlag.Static));
        Assertions.assertEquals(49, methods.get(1).getNameIndex());
        Assertions.assertEquals(50, methods.get(1).getDescriptorIndex());
        Assertions.assertEquals(2, methods.get(1).getAttributes().getCount());
        Assertions.assertEquals(47, methods.get(1).getAttributes().get(0).getNameIndex());
        Assertions.assertEquals(147, methods.get(1).getAttributes().get(0).getLength());

    }
}