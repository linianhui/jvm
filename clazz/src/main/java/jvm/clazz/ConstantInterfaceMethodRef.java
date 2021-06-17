package jvm.clazz;

public class ConstantInterfaceMethodRef extends Constant {
    private final int classIndex;
    private final int nameAndTypeIndex;

    public ConstantInterfaceMethodRef(final Memory memory) {
        super(Tag.InterfaceMethodRef);
        classIndex = memory.readShortAsInt();
        nameAndTypeIndex = memory.readShortAsInt();
    }

    public int getClassIndex() {
        return classIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }
}
