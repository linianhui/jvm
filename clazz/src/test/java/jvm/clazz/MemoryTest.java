package jvm.clazz;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryTest extends AbstractTest {

    @Test
    void test_readByte() {
        Memory memory = newMemory(0xCA, 0xFE, 0xBA, 0xBE);
        Assertions.assertEquals((byte) 0xCA, memory.readByte());
        Assertions.assertEquals(1, memory.getPosition());

        Assertions.assertEquals((byte) 0xFE, memory.readByte());
        Assertions.assertEquals(2, memory.getPosition());

        Assertions.assertEquals((byte) 0xBA, memory.readByte());
        Assertions.assertEquals(3, memory.getPosition());

        Assertions.assertEquals((byte) 0xBE, memory.readByte());
        Assertions.assertEquals(4, memory.getPosition());
    }

    @Test
    void test_readShort() {
        Memory memory = newMemory(0xFF, 0xFF);
        Assertions.assertEquals(-1, memory.readShort());
        Assertions.assertEquals(2, memory.getPosition());
    }

    @Test
    void test_readUnsignedShort() {
        Memory memory = newMemory(0xFF, 0xFF);
        Assertions.assertEquals(65535, memory.readUnsignedShort());
        Assertions.assertEquals(2, memory.getPosition());
    }

    @Test
    void test_readInt() {
        Memory memory = newMemory(0xCA, 0xFE, 0xBA, 0xBE);
        Assertions.assertEquals(0xCA_FE_BA_BE, memory.readInt());
        Assertions.assertEquals(4, memory.getPosition());
    }

}