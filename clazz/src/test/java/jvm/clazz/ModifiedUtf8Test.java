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
}