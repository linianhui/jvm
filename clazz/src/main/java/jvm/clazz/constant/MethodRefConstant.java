package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class MethodRefConstant extends Constant {
    private final int classIndex;
    private final int nameAndTypeIndex;

    public MethodRefConstant(final Clazz clazz, final Memory memory) {
        super(clazz,Tag.MethodRef);
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
