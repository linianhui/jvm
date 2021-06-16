package jvm.clazz;

public class ConstantLong extends Constant {
    private final long value;

    public ConstantLong(final Memory memory) {
        super(ConstantTag.Long);
        value = memory.readLong();
    }

    public long getValue() {
        return value;
    }
}
