package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class IntegerConstant extends Constant {
    private final int value;

    public IntegerConstant(final Clazz clazz, final Memory memory) {
        super(clazz,Tag.Integer);
        value = memory.readInt();
    }

    public int getValue() {
        return value;
    }
}
