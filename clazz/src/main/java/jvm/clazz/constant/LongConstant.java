package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class LongConstant extends Constant {
    private final long value;

    public LongConstant(final Clazz clazz, final Bytes bytes) {
        super(clazz,Tag.Long);
        value = bytes.readLong();
    }

    public long getValue() {
        return value;
    }
}
