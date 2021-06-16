package jvm.clazz;

public class ConstantMethodHandle extends Constant {
    private final byte referenceKind;
    private final int referenceIndex;

    public ConstantMethodHandle(final Memory memory) {
        super(ConstantTag.MethodHandle);
        referenceKind = memory.readByte();
        referenceIndex = memory.readShortAsInt();
    }

    public byte getReferenceKind() {
        return referenceKind;
    }

    public int getReferenceIndex() {
        return referenceIndex;
    }
}
