package jvm.clazz;

public class Memory {
    private byte[] raw;
    private int position;
    private int length;

    public Memory(final byte[] raw) {
        this.raw = raw;
        this.position = 0;
        this.length = raw.length;
    }

    public int getPosition() {
        return position;
    }

    public byte readByte() {
        int index = position;
        position = position + 1;
        return raw[index];
    }

    public int readByteAsInt() {
        return readByte() & 0xFF;
    }

    public short readShort() {
        return (short) readUnsignedShort();
    }

    public int readUnsignedShort() {
        int result = readByteAsInt();
        result <<= 8;
        result = result | readByteAsInt();
        return result;
    }

    public int readInt() {
        int result = readByteAsInt();
        result <<= 8;
        result = result | readByteAsInt();
        result <<= 8;
        result = result | readByteAsInt();
        result <<= 8;
        result = result | readByteAsInt();
        return result;
    }

    public int getLength() {
        return length;
    }
}
