package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class ModuleConstant extends Constant {
    private final int nameIndex;

    public ModuleConstant(final Clazz clazz, final Memory memory) {
        super(clazz,Tag.Module);
        nameIndex = memory.readShortAsInt();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}
