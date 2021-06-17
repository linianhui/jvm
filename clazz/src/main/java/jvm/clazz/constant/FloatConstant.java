package jvm.clazz.constant;

import jvm.clazz.Memory;

public class FloatConstant extends Constant {
    private final float value;

    public FloatConstant(final Memory memory) {
        super(Tag.Float);
        value = memory.readFloat();
    }

    public float getValue() {
        return value;
    }
}
