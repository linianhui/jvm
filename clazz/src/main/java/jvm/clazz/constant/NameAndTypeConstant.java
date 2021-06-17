package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class NameAndTypeConstant extends Constant {
    private final int nameIndex;
    private final int descriptorIndex;

    public NameAndTypeConstant(final Clazz clazz, final Bytes bytes) {
        super(clazz,Tag.MethodRef);
        nameIndex = bytes.readShortAsInt();
        descriptorIndex = bytes.readShortAsInt();
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }
}
