package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class DynamicConstant extends Constant {
    private final int bootstrapMethodAttributeIndex;
    private final int nameAndTypeIndex;

    public DynamicConstant(final Clazz clazz, final Bytes bytes) {
        super(clazz,Tag.Dynamic);
        bootstrapMethodAttributeIndex = bytes.readShortAsInt();
        nameAndTypeIndex = bytes.readShortAsInt();
    }

    public int getBootstrapMethodAttributeIndex() {
        return bootstrapMethodAttributeIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }
}
