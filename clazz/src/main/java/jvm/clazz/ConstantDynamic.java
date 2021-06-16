package jvm.clazz;

public class ConstantDynamic extends Constant {
    private final int bootstrapMethodAttributeIndex;
    private final int nameAndTypeIndex;

    public ConstantDynamic(final Memory memory) {
        super(ConstantTag.Dynamic);
        bootstrapMethodAttributeIndex = memory.readUnsignedShort();
        nameAndTypeIndex = memory.readUnsignedShort();
    }

    public int getBootstrapMethodAttributeIndex() {
        return bootstrapMethodAttributeIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }
}
