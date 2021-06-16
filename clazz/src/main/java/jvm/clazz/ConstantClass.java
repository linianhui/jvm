package jvm.clazz;

public class ConstantClass extends Constant {
    private int nameIndex;

    public ConstantClass(byte tag, final Memory memory) {
        super(tag);
        nameIndex = memory.readUnsignedShort();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}
