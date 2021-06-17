package jvm.clazz;

public class ConstantString extends Constant {
    private final int stringIndex;

    public ConstantString(final Memory memory) {
        super(Tag.String);
        stringIndex = memory.readShortAsInt();
    }

    public int getNameIndex() {
        return stringIndex;
    }
}
