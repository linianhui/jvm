package jvm.clazz;

public class ConstantNameAndType extends Constant {
    private final int nameIndex;
    private final int descriptorIndex;

    public ConstantNameAndType(final Memory memory) {
        super(Tag.MethodRef);
        nameIndex = memory.readShortAsInt();
        descriptorIndex = memory.readShortAsInt();
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }
}
