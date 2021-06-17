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

        Attribute[] attributes = Attribute.from(memory, 2);

        Assertions.assertEquals(2, attributes.length);
        Assertions.assertEquals(56, attributes[0].getNameIndex());
        Assertions.assertEquals(2, attributes[0].getLength());
        Assertions.assertEquals(58, attributes[1].getNameIndex());
        Assertions.assertEquals(2, attributes[1].getLength());
    }
}