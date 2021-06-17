package jvm.clazz.constant;

import jvm.clazz.Memory;

public class ConstantPackage extends Constant {
    private final int nameIndex;

    public ConstantPackage(final Memory memory) {
        super(Tag.Package);
        nameIndex = memory.readShortAsInt();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}
