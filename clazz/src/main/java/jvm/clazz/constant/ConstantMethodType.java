package jvm.clazz.constant;

import jvm.clazz.Memory;

public class ConstantMethodType extends Constant {
    private final int descriptorIndex;

    public ConstantMethodType(final Memory memory) {
        super(Tag.MethodRef);
        descriptorIndex = memory.readShortAsInt();
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }
}
