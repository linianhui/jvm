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
        Fields fields = Fields.from(null,memory, 2);

        Assertions.assertEquals(2, fields.getItems().length);

        Assertions.assertEquals(3, fields.getItems()[0].getAccessFlags().size());
        Assertions.assertTrue(fields.getItems()[0].getAccessFlags().contains(Field.AccessFlag.Public));
        Assertions.assertTrue(fields.getItems()[0].getAccessFlags().contains(Field.AccessFlag.Static));
        Assertions.assertTrue(fields.getItems()[0].getAccessFlags().contains(Field.AccessFlag.Final));
        Assertions.assertEquals(22, fields.getItems()[0].getNameIndex());
        Assertions.assertEquals(23, fields.getItems()[0].getDescriptorIndex());
        Assertions.assertEquals(1, fields.getItems()[0].getAttributes().getCount());
        Assertions.assertEquals(1, fields.getItems()[0].getAttributes().getItems().length);
        Assertions.assertEquals(24, fields.getItems()[0].getAttributes().getItems()[0].getNameIndex());
        Assertions.assertEquals(2, fields.getItems()[0].getAttributes().getItems()[0].getLength());

        Assertions.assertEquals(3, fields.getItems()[1].getAccessFlags().size());
        Assertions.assertTrue(fields.getItems()[1].getAccessFlags().contains(Field.AccessFlag.Public));
        Assertions.assertTrue(fields.getItems()[1].getAccessFlags().contains(Field.AccessFlag.Static));
        Assertions.assertTrue(fields.getItems()[1].getAccessFlags().contains(Field.AccessFlag.Final));
        Assertions.assertEquals(26, fields.getItems()[1].getNameIndex());
        Assertions.assertEquals(27, fields.getItems()[1].getDescriptorIndex());
        Assertions.assertEquals(1, fields.getItems()[1].getAttributes().getCount());
        Assertions.assertEquals(1, fields.getItems()[1].getAttributes().getItems().length);
        Assertions.assertEquals(24, fields.getItems()[1].getAttributes().getItems()[0].getNameIndex());
        Assertions.assertEquals(2, fields.getItems()[1].getAttributes().getItems()[0].getLength());

    }
}