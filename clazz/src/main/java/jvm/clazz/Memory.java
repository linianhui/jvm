package jvm.clazz;

public class Memory {
    private byte[] raw;
    private int begin;
    private int position;
    private int length;

    public Memory(final byte[] raw) {
        this.raw = raw;
        this.begin = 0;
        this.position = 0;
        this.length = raw.length;
    }

    public int getPosition() {
        return position;
    }

    public byte readByte() {
        byte b = raw[this.begin + this.position];
        position = position + 1;
        return b;
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

    public Memory slice(int length) {
        final Memory memory = new Memory(this.raw);
        memory.begin = this.position;
        memory.position = 0;
        memory.length = this.length - this.position;
        this.position = this.position + length;
        return memory;
    }
}
