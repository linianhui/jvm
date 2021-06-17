package jvm.clazz;

public class Memory {
    private final byte[] raw;
    private final int begin;
    private int position;
    private final int length;

    public Memory(final byte[] raw) {
        this(raw, 0, raw.length);
    }

    public Memory(final byte[] raw, int begin, int length) {
        this.raw = raw;
        this.begin = begin;
        this.position = 0;
        this.length = length;
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

    public long readByteAsLong() {
        return readByteAsInt();
    }

    public short readShort() {
        return (short) readShortAsInt();
    }

    public int readShortAsInt() {
        int i1 = readByteAsInt();
        int i2 = readByteAsInt();
        return i1 << 8 | i2;
    }

    public int readInt() {
        int i1 = readByteAsInt();
        int i2 = readByteAsInt();
        int i3 = readByteAsInt();
        int i4 = readByteAsInt();
        return (i1 << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    public long readLong() {
        long l1 = readByteAsLong();
        long l2 = readByteAsLong();
        long l3 = readByteAsLong();
        long l4 = readByteAsLong();
        long l5 = readByteAsLong();
        long l6 = readByteAsLong();
        long l7 = readByteAsLong();
        long l8 = readByteAsLong();
        return (l1 << 56) | (l2 << 48) | (l3 << 40) | (l4 << 32) | (l5 << 24) | (l6 << 16) | (l7 << 8) | l8;
    }

    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public int getLength() {
        return length;
    }

    public Memory slice(int length) {
        final Memory memory = new Memory(this.raw, this.position, length);
        this.position = this.position + length;
        return memory;
    }
}
