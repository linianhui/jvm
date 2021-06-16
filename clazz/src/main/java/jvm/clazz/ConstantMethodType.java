package jvm.clazz;

public class ConstantMethodType extends Constant {
    private final int descriptorIndex;

    public ConstantMethodType(final Memory memory) {
        super(ConstantTag.MethodRef);
        descriptorIndex = memory.readShortAsInt();
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }
}
