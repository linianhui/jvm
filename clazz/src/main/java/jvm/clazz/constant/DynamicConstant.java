package jvm.clazz.constant;

import jvm.clazz.Memory;

public class DynamicConstant extends Constant {
    private final int bootstrapMethodAttributeIndex;
    private final int nameAndTypeIndex;

    public DynamicConstant(final Memory memory) {
        super(Tag.Dynamic);
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
