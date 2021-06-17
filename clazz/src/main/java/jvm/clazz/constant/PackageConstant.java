package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class PackageConstant extends Constant {
    private final int nameIndex;

    public PackageConstant(final Clazz clazz, final Memory memory) {
        super(clazz,Tag.Package);
        nameIndex = memory.readShortAsInt();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}
