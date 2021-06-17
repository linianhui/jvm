package jvm.clazz.constant;

import jvm.clazz.Memory;

public class InvokeDynamicConstant extends Constant {
    private final int bootstrapMethodAttributeIndex;
    private final int nameAndTypeIndex;

    public InvokeDynamicConstant(final Memory memory) {
        super(Tag.InvokeDynamic);
        bootstrapMethodAttributeIndex = memory.readShortAsInt();
        nameAndTypeIndex = memory.readShortAsInt();
    }

    public int getBootstrapMethodAttributeIndex() {
        return bootstrapMethodAttributeIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }
}
