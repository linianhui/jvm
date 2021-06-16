package jvm.clazz;

public class Memory {
    private byte[] raw;
    private int position;

    public int getPosition(){
        return position;
    }

    public Memory(final byte[] raw) {
        this.raw = raw;
        this.position = 0;
    }

    public byte readByte() {
        int index = position;
        position = position + 1;
        return raw[index];
    }
}
