package jvm.clazz.constant;

import jvm.clazz.Memory;

public class ConstantLong extends Constant {
    private final long value;

    public ConstantLong(final Memory memory) {
        super(Tag.Long);
        value = memory.readLong();
    }

    public long getValue() {
        return value;
    }
}
