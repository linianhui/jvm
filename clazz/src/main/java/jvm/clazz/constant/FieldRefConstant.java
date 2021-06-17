package jvm.clazz.constant;

import jvm.clazz.Memory;

public class FieldRefConstant extends Constant {
    private final int classIndex;
    private final int nameAndTypeIndex;

    public FieldRefConstant(final Memory memory) {
        super(Tag.FieldRef);
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
