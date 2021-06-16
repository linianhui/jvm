package jvm.clazz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ModifiedUtf8Test extends AbstractTest {

    @Test
    void test_ToString() {
        Memory memory = newMemory(
                0x28, 0x4C, 0x6A, 0x61, 0x76, 0x61, 0x2F, 0x6C, 0x61, 0x6E, 0x67, 0x2F, 0x53, 0x74, 0x72,
                0x69, 0x6E, 0x67, 0x3B, 0x29, 0x56
        );
        String value = ModifiedUtf8.toString(memory);

        Assertions.assertEquals(21, memory.getLength());
        Assertions.assertEquals("(Ljava/lang/String;)V", value);
    }

    @Test
    void test_ToString_emoji() {
        Memory memory = newMemory(
            0x4C, 0x4E, 0x48, 0xE4, 0xB8, 0xAD, 0xE6, 0x96, 0x87, 0xED, 0xA0, 0xBD, 0xED, 0xB8, 0x80
        );
        String value = ModifiedUtf8.toString(memory);

        Assertions.assertEquals(15, memory.getLength());
        Assertions.assertEquals("LNH中文😀", value);
    }
}