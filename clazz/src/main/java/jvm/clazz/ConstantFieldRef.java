package jvm.clazz;

public class ConstantFieldRef extends Constant {
    private final int classIndex;
    private final int nameAndTypeIndex;

    public ConstantFieldRef(final Memory memory) {
        super(ConstantTag.FieldRef);
        classIndex = memory.readUnsignedShort();
        nameAndTypeIndex = memory.readUnsignedShort();
    }

    public int getClassIndex() {
        return classIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }
}
