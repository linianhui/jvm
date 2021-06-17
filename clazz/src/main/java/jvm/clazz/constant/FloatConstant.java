package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class FloatConstant extends Constant {
    private final float value;

    public FloatConstant(final Clazz clazz, final Bytes bytes) {
        super(clazz,Tag.Float);
        value = bytes.readFloat();
    }

    public float getValue() {
        return value;
    }
}
