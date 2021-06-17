package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class MethodTypeConstant extends Constant {
    private final int descriptorIndex;

    public MethodTypeConstant(final Clazz clazz, final Bytes bytes) {
        super(clazz,Tag.MethodRef);
        descriptorIndex = bytes.readShortAsInt();
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }
}
