package jvm.clazz;

public class ConstantClass extends Constant {
    private int nameIndex;

    public ConstantClass(final Memory memory) {
        super(ConstantTag.Class);
        nameIndex = memory.readUnsignedShort();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}
