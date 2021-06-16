package jvm.clazz;

public class ConstantInvokeDynamic extends Constant {
    private final int bootstrapMethodAttributeIndex;
    private final int nameAndTypeIndex;

    public ConstantInvokeDynamic(final Memory memory) {
        super(ConstantTag.Dynamic);
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
