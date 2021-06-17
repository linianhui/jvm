package jvm.clazz;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FieldTest extends AbstractTest {

    @Test
    void test_Field() {
        Memory memory = newMemory(
            0x00, 0x19, 0x00, 0x16, 0x00, 0x17, 0x00, 0x01, 0x00, 0x18, 0x00, 0x00, 0x00, 0x02, 0x00,
            0x19, 0x00, 0x19, 0x00, 0x1A, 0x00, 0x1B, 0x00, 0x01, 0x00, 0x18, 0x00, 0x00, 0x00, 0x02,
            0x00, 0x1C
        );
        Field[] fields = Field.from(memory, 2);

        Assertions.assertEquals(2, fields.length);

        Assertions.assertEquals(3, fields[0].getAccessFlags().size());
        Assertions.assertTrue(fields[0].getAccessFlags().contains(Field.AccessFlag.Public));
        Assertions.assertTrue(fields[0].getAccessFlags().contains(Field.AccessFlag.Static));
        Assertions.assertTrue(fields[0].getAccessFlags().contains(Field.AccessFlag.Final));
        Assertions.assertEquals(22, fields[0].getNameIndex());
        Assertions.assertEquals(23, fields[0].getDescriptorIndex());
        Assertions.assertEquals(1, fields[0].getAttributesCount());
        Assertions.assertEquals(1, fields[0].getAttributes().length);
        Assertions.assertEquals(24, fields[0].getAttributes()[0].getNameIndex());
        Assertions.assertEquals(2, fields[0].getAttributes()[0].getLength());

        Assertions.assertEquals(3, fields[1].getAccessFlags().size());
        Assertions.assertTrue(fields[1].getAccessFlags().contains(Field.AccessFlag.Public));
        Assertions.assertTrue(fields[1].getAccessFlags().contains(Field.AccessFlag.Static));
        Assertions.assertTrue(fields[1].getAccessFlags().contains(Field.AccessFlag.Final));
        Assertions.assertEquals(26, fields[1].getNameIndex());
        Assertions.assertEquals(27, fields[1].getDescriptorIndex());
        Assertions.assertEquals(1, fields[1].getAttributesCount());
        Assertions.assertEquals(1, fields[1].getAttributes().length);
        Assertions.assertEquals(24, fields[1].getAttributes()[0].getNameIndex());
        Assertions.assertEquals(2, fields[1].getAttributes()[0].getLength());

    }
}