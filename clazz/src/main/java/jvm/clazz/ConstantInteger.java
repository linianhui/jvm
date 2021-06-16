package jvm.clazz;

public class ConstantInteger extends Constant {
    private final int value;

    public ConstantInteger(final Memory memory) {
        super(ConstantTag.Integer);
        value = memory.readInt();
    }

    public int getValue() {
        return value;
    }
}
