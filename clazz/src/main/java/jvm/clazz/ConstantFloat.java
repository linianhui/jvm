package jvm.clazz;

public class ConstantFloat extends Constant {
    private final float value;

    public ConstantFloat(final Memory memory) {
        super(ConstantTag.Float);
        value = memory.readFloat();
    }

    public float getValue() {
        return value;
    }
}
