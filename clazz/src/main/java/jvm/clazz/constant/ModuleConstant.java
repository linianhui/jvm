package jvm.clazz.constant;

import jvm.clazz.Memory;

public class ModuleConstant extends Constant {
    private final int nameIndex;

    public ModuleConstant(final Memory memory) {
        super(Tag.Module);
        nameIndex = memory.readShortAsInt();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}
