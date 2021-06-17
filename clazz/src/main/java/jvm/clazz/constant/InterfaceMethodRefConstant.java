package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class InterfaceMethodRefConstant extends Constant {
    private final int classIndex;
    private final int nameAndTypeIndex;

    public InterfaceMethodRefConstant(final Clazz clazz, final Memory memory) {
        super(clazz,Tag.InterfaceMethodRef);
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
