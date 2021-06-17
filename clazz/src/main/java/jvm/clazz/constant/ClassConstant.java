package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class ClassConstant extends Constant {
    private final int nameIndex;

    public ClassConstant(final Clazz clazz, final Bytes bytes) {
        super(clazz,Tag.Class);
        nameIndex = bytes.readShortAsInt();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}
