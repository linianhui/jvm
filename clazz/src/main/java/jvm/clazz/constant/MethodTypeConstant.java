package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class MethodTypeConstant extends Constant {
    private final int descriptorIndex;

    public MethodTypeConstant(final Clazz clazz, final Memory memory) {
        super(clazz,Tag.MethodRef);
        descriptorIndex = memory.readShortAsInt();
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }
}
