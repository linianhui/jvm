package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class IntegerConstant extends Constant {
    private final int value;

    public IntegerConstant(final Clazz clazz, final Bytes bytes) {
        super(clazz,Tag.Integer);
        value = bytes.readInt();
    }

    public int getValue() {
        return value;
    }
}
