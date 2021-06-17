package jvm.clazz.constant;

import jvm.clazz.Memory;

public class ClassConstant extends Constant {
    private final int nameIndex;

    public ClassConstant(final Memory memory) {
        super(Tag.Class);
        nameIndex = memory.readShortAsInt();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}
