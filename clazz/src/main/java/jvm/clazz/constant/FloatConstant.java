package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class FloatConstant extends Constant {
    private final float value;

    public FloatConstant(final Clazz clazz, final Memory memory) {
        super(clazz,Tag.Float);
        value = memory.readFloat();
    }

    public float getValue() {
        return value;
    }
}
