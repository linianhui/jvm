package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class NameAndTypeConstant extends Constant {
    private final int nameIndex;
    private final int descriptorIndex;

    public NameAndTypeConstant(final Clazz clazz, final Memory memory) {
        super(clazz,Tag.MethodRef);
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
