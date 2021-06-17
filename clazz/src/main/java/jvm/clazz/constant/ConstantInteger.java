package jvm.clazz.constant;

import jvm.clazz.Memory;

public class ConstantInteger extends Constant {
    private final int value;

    public ConstantInteger(final Memory memory) {
        super(Tag.Integer);
        value = memory.readInt();
    }

    public int getValue() {
        return value;
    }
}