package jvm.clazz.constant;

import jvm.clazz.Memory;

public class ConstantClass extends Constant {
    private final int nameIndex;

    public ConstantClass(final Memory memory) {
        super(Tag.Class);
        nameIndex = memory.readShortAsInt();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}