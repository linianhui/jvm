package jvm.clazz;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FieldTest extends AbstractTest {

    @Test
    void test_Field() {
        Bytes bytes = newBytes(
            0x00, 0x02,
            0x00, 0x19, 0x00, 0x16, 0x00, 0x17, 0x00, 0x01, 0x00, 0x18, 0x00, 0x00, 0x00, 0x02, 0x00,
            0x19, 0x00, 0x19, 0x00, 0x1A, 0x00, 0x1B, 0x00, 0x01, 0x00, 0x18, 0x00, 0x00, 0x00, 0x02,
            0x00, 0x1C
        );
        Fields fields = Fields.from(null, bytes);

        Assertions.assertEquals(2, fields.getCount());

        Assertions.assertEquals(3, fields.get(0).getAccessFlags().size());
        Assertions.assertTrue(fields.get(0).getAccessFlags().contains(Field.AccessFlag.Public));
        Assertions.assertTrue(fields.get(0).getAccessFlags().contains(Field.AccessFlag.Static));
        Assertions.assertTrue(fields.get(0).getAccessFlags().contains(Field.AccessFlag.Final));
        Assertions.assertEquals(22, fields.get(0).getNameIndex());
        Assertions.assertEquals(23, fields.get(0).getDescriptorIndex());
        Assertions.assertEquals(1, fields.get(0).getAttributes().getCount());
        Assertions.assertEquals(24, fields.get(0).getAttributes().get(0).getNameIndex());
        Assertions.assertEquals(2, fields.get(0).getAttributes().get(0).getLength());

        Assertions.assertEquals(3, fields.get(1).getAccessFlags().size());
        Assertions.assertTrue(fields.get(1).getAccessFlags().contains(Field.AccessFlag.Public));
        Assertions.assertTrue(fields.get(1).getAccessFlags().contains(Field.AccessFlag.Static));
        Assertions.assertTrue(fields.get(1).getAccessFlags().contains(Field.AccessFlag.Final));
        Assertions.assertEquals(26, fields.get(1).getNameIndex());
        Assertions.assertEquals(27, fields.get(1).getDescriptorIndex());
        Assertions.assertEquals(1, fields.get(1).getAttributes().getCount());
        Assertions.assertEquals(24, fields.get(1).getAttributes().get(0).getNameIndex());
        Assertions.assertEquals(2, fields.get(1).getAttributes().get(0).getLength());

    }
}