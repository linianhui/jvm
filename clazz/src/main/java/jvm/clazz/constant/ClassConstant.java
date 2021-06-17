package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class ClassConstant extends Constant {
    private final int nameIndex;

    public ClassConstant(final Clazz clazz, final Memory memory) {
        super(clazz,Tag.Class);
        nameIndex = memory.readShortAsInt();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}
