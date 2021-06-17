package jvm.clazz;

public class ConstantMethodRef extends Constant {
    private final int classIndex;
    private final int nameAndTypeIndex;

    public ConstantMethodRef(final Memory memory) {
        super(Tag.MethodRef);
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
