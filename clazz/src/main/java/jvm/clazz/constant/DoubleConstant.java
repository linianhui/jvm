package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class DoubleConstant extends Constant {
    private final double value;

    public DoubleConstant(final Clazz clazz, final Bytes bytes) {
        super(clazz,Tag.Double);
        value = bytes.readDouble();
    }

    public double getValue() {
        return value;
    }
}
