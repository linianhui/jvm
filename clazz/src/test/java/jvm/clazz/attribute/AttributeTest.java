package jvm.clazz.attribute;

import jvm.clazz.AbstractTest;
import jvm.clazz.Memory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AttributeTest extends AbstractTest {

    @Test
    void test_Attribute() {
        Memory memory = newMemory(
            0x00, 0x38, 0x00, 0x00, 0x00, 0x02, 0x00, 0x39,
            0x00, 0x3A, 0x00, 0x00, 0x00, 0x02, 0x00, 0x3B
        );

        Attributes attributes = Attributes.from(null, memory, 2);

        Assertions.assertEquals(2, attributes.getItems().length);
        Assertions.assertEquals(56, attributes.getItems()[0].getNameIndex());
        Assertions.assertEquals(2, attributes.getItems()[0].getLength());
        Assertions.assertEquals(58, attributes.getItems()[1].getNameIndex());
        Assertions.assertEquals(2, attributes.getItems()[1].getLength());
    }
}