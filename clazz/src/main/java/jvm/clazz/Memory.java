package jvm.clazz;

public class Memory {
    private byte[] raw;
    private int position;

    public Memory(final byte[] raw) {
        this.raw = raw;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public byte readByte() {
        int index = position;
        position = position + 1;
        return raw[index];
    }

    private int readByteAsInt(){
        return readByte() & 0xFF;
    }

    public short readShort() {
        int result = readByteAsInt();
        result <<= 8;
        result = result | readByteAsInt();
        return (short) result;
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
}
