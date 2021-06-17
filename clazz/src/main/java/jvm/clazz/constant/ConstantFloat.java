package jvm.clazz.constant;

import jvm.clazz.Memory;

public class ConstantFloat extends Constant {
    private final float value;

    public ConstantFloat(final Memory memory) {
        super(Tag.Float);
        value = memory.readFloat();
    }

    public float getValue() {
        return value;
    }
}
