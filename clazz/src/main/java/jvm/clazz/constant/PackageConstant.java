package jvm.clazz.constant;

import jvm.clazz.Memory;

public class PackageConstant extends Constant {
    private final int nameIndex;

    public PackageConstant(final Memory memory) {
        super(Tag.Package);
        nameIndex = memory.readShortAsInt();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}
