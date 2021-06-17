package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class DoubleConstant extends Constant {
    private final double value;

    public DoubleConstant(final Clazz clazz, final Memory memory) {
        super(clazz,Tag.Double);
        value = memory.readDouble();
    }

    public double getValue() {
        return value;
    }
}
