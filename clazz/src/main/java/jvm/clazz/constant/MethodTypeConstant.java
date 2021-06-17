package jvm.clazz.constant;

import jvm.clazz.Memory;

public class MethodTypeConstant extends Constant {
    private final int descriptorIndex;

    public MethodTypeConstant(final Memory memory) {
        super(Tag.MethodRef);
        descriptorIndex = memory.readShortAsInt();
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }
}
