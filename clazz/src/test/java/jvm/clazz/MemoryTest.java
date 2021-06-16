package jvm.clazz;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryTest {

    @Test
    void test_readByte() {
        Memory memory = new Memory(getBytes());
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
        Memory memory = new Memory(getBytes());
        Assertions.assertEquals((short) 0xCA_FE, memory.readShort());
        Assertions.assertEquals(2, memory.getPosition());

        Assertions.assertEquals((short) 0xBA_BE, memory.readShort());
        Assertions.assertEquals(4, memory.getPosition());
    }

    @Test
    void test_readInt() {
        Memory memory = new Memory(getBytes());
        Assertions.assertEquals(0xCA_FE_BA_BE, memory.readInt());
        Assertions.assertEquals(4, memory.getPosition());
    }

    private byte[] getBytes() {
        return new byte[]{
                (byte) 0xCA, (byte) 0xFE, (byte) 0xBA, (byte) 0xBE
        };
    }
}