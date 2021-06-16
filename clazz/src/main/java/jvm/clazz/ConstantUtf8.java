package jvm.clazz;

public class ConstantUtf8 extends Constant {
    private int length;
    private String value;

    public ConstantUtf8(byte tag, Memory memory) {
        super(tag);
        this.length = memory.readUnsignedShort();
    }
}
