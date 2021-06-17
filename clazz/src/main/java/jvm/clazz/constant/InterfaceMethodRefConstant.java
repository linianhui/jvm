package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class InterfaceMethodRefConstant extends Constant {
    private final int classIndex;
    private final int nameAndTypeIndex;

    public InterfaceMethodRefConstant(final Clazz clazz, final Bytes bytes) {
        super(clazz,Tag.InterfaceMethodRef);
        classIndex = bytes.readShortAsInt();
        nameAndTypeIndex = bytes.readShortAsInt();
    }

    public int getClassIndex() {
        return classIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }
}
