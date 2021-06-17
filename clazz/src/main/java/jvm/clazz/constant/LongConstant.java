package jvm.clazz.constant;

import jvm.clazz.Memory;

public class LongConstant extends Constant {
    private final long value;

    public LongConstant(final Memory memory) {
        super(Tag.Long);
        value = memory.readLong();
    }

    public long getValue() {
        return value;
    }
}
