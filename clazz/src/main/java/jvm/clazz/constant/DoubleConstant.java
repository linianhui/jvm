package jvm.clazz.constant;

import jvm.clazz.Memory;

public class DoubleConstant extends Constant {
    private final double value;

    public DoubleConstant(final Memory memory) {
        super(Tag.Double);
        value = memory.readDouble();
    }

    public double getValue() {
        return value;
    }
}
