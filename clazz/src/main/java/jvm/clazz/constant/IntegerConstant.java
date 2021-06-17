package jvm.clazz.constant;

import jvm.clazz.Memory;

public class IntegerConstant extends Constant {
    private final int value;

    public IntegerConstant(final Memory memory) {
        super(Tag.Integer);
        value = memory.readInt();
    }

    public int getValue() {
        return value;
    }
}
