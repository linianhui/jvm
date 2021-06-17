package jvm.clazz;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BytesTest extends AbstractTest {

    @Test
    void test_getLength() {
        Bytes bytes = newBytes(0xCA, 0xFE, 0xBA, 0xBE);
        Assertions.assertEquals(4, bytes.getLength());
    }

    @Test
    void test_getPosition() {
        Bytes bytes = newBytes(0xCA, 0xFE, 0xBA, 0xBE);
        Assertions.assertEquals(0, bytes.getPosition());
    }

    @Test
    void test_readByte() {
        Bytes bytes = newBytes(0xCA, 0xFE, 0xBA, 0xBE);
        Assertions.assertEquals((byte) 0xCA, bytes.readByte());
        Assertions.assertEquals(1, bytes.getPosition());

        Assertions.assertEquals((byte) 0xFE, bytes.readByte());
        Assertions.assertEquals(2, bytes.getPosition());

        Assertions.assertEquals((byte) 0xBA, bytes.readByte());
        Assertions.assertEquals(3, bytes.getPosition());

        Assertions.assertEquals((byte) 0xBE, bytes.readByte());
        Assertions.assertEquals(4, bytes.getPosition());
    }

    @Test
    void test_readByteAsInt() {
        Bytes bytes = newBytes(0xCA, 0xFE, 0xBA, 0xBE);
        Assertions.assertEquals(0xCA, bytes.readByteAsInt());
        Assertions.assertEquals(1, bytes.getPosition());

        Assertions.assertEquals(0xFE, bytes.readByteAsInt());
        Assertions.assertEquals(2, bytes.getPosition());

        Assertions.assertEquals(0xBA, bytes.readByteAsInt());
        Assertions.assertEquals(3, bytes.getPosition());

        Assertions.assertEquals(0xBE, bytes.readByteAsInt());
        Assertions.assertEquals(4, bytes.getPosition());
    }

    @Test
    void test_readByteAsLong() {
        Bytes bytes = newBytes(0xCA, 0xFE, 0xBA, 0xBE);
        Assertions.assertEquals(0xCAL, bytes.readByteAsLong());
        Assertions.assertEquals(1, bytes.getPosition());

        Assertions.assertEquals(0xFEL, bytes.readByteAsLong());
        Assertions.assertEquals(2, bytes.getPosition());

        Assertions.assertEquals(0xBAL, bytes.readByteAsLong());
        Assertions.assertEquals(3, bytes.getPosition());

        Assertions.assertEquals(0xBEL, bytes.readByteAsLong());
        Assertions.assertEquals(4, bytes.getPosition());
    }

    @Test
    void test_readShort() {
        Bytes bytes = newBytes(0xFF, 0xFF);
        Assertions.assertEquals(-1, bytes.readShort());
        Assertions.assertEquals(2, bytes.getPosition());
    }

    @Test
    void test_readShortAsInt() {
        Bytes bytes = newBytes(0xFF, 0xFF);
        Assertions.assertEquals(65535, bytes.readShortAsInt());
        Assertions.assertEquals(2, bytes.getPosition());
    }

    @Test
    void test_readInt() {
        Bytes bytes = newBytes(0xCA, 0xFE, 0xBA, 0xBE);
        Assertions.assertEquals(0xCA_FE_BA_BE, bytes.readInt());
        Assertions.assertEquals(4, bytes.getPosition());
    }

    @Test
    void test_readFloat() {
        Bytes bytes = newBytes(0x40, 0x49, 0x0F, 0xDB);
        Assertions.assertEquals(3.14159265f, bytes.readFloat());
        Assertions.assertEquals(4, bytes.getPosition());
    }

    @Test
    void test_readLong() {
        Bytes bytes = newBytes(0x12, 0x34, 0x56, 0x78, 0x9A, 0xBC, 0xDE, 0xF0);
        Assertions.assertEquals(0x12_34_56_78_9A_BC_DE_F0L, bytes.readLong());
        Assertions.assertEquals(8, bytes.getPosition());
    }

    @Test
    void test_readDouble() {
        Bytes bytes = newBytes(0x40, 0x09, 0x21, 0xFB, 0x54, 0x44, 0x2D, 0x18);
        Assertions.assertEquals(3.1415_9265_3589_7932_3846D, bytes.readDouble());
        Assertions.assertEquals(8, bytes.getPosition());
    }
}