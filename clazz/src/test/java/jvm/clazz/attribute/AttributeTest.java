package jvm.clazz.attribute;

import jvm.clazz.AbstractTest;
import jvm.clazz.Bytes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AttributeTest extends AbstractTest {

    @Test
    void test_Attribute() {
        Bytes bytes = newBytes(
            0x00, 0x02, 0x00, 0x38, 0x00, 0x00, 0x00, 0x02, 0x00, 0x39,
            0x00, 0x3A, 0x00, 0x00, 0x00, 0x02, 0x00, 0x3B
        );

        Attributes attributes = Attributes.from(null, bytes);

        Assertions.assertEquals(2, attributes.getCount());
        Assertions.assertEquals(56, attributes.get(0).getNameIndex());
        Assertions.assertEquals(2, attributes.get(0).getLength());
        Assertions.assertEquals(58, attributes.get(1).getNameIndex());
        Assertions.assertEquals(2, attributes.get(1).getLength());
    }
}