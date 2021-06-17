package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class ModuleConstant extends Constant {
    private final int nameIndex;

    public ModuleConstant(final Clazz clazz, final Bytes bytes) {
        super(clazz,Tag.Module);
        nameIndex = bytes.readShortAsInt();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}
