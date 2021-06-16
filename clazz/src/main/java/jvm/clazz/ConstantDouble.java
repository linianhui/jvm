package jvm.clazz;

public class ConstantDouble extends Constant {
    private final double value;

    public ConstantDouble(final Memory memory) {
        super(ConstantTag.Double);
        value = memory.readDouble();
    }

    public double getValue() {
        return value;
    }
}
