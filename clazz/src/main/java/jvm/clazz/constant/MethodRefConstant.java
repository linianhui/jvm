package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class MethodRefConstant extends Constant {
    private final int classIndex;
    private final int nameAndTypeIndex;

    public MethodRefConstant(final Clazz clazz, final Bytes bytes) {
        super(clazz,Tag.MethodRef);
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
