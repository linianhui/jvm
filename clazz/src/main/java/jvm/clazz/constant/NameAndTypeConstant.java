package jvm.clazz.constant;

import jvm.clazz.Memory;

public class NameAndTypeConstant extends Constant {
    private final int nameIndex;
    private final int descriptorIndex;

    public NameAndTypeConstant(final Memory memory) {
        super(Tag.MethodRef);
        nameIndex = memory.readShortAsInt();
        descriptorIndex = memory.readShortAsInt();
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }
}
