package jvm.clazz.constant;

import jvm.clazz.Memory;

public class ConstantModule extends Constant {
    private final int nameIndex;

    public ConstantModule(final Memory memory) {
        super(Tag.Module);
        nameIndex = memory.readShortAsInt();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}
