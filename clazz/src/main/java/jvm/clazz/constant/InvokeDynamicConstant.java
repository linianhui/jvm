package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class InvokeDynamicConstant extends Constant {
    private final int bootstrapMethodAttributeIndex;
    private final int nameAndTypeIndex;

    public InvokeDynamicConstant(final Clazz clazz, final Bytes bytes) {
        super(clazz,Tag.InvokeDynamic);
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
