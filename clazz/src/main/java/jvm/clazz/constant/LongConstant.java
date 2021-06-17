package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class LongConstant extends Constant {
    private final long value;

    public LongConstant(final Clazz clazz, final Memory memory) {
        super(clazz,Tag.Long);
        value = memory.readLong();
    }

    public long getValue() {
        return value;
    }
}
