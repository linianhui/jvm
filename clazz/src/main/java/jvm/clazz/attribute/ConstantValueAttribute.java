package jvm.clazz.attribute;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class ConstantValueAttribute extends Attribute {
    private final int constantValueIndex;

    protected ConstantValueAttribute(final Clazz clazz, int nameIndex, String name, Memory memory) {
        super(clazz, nameIndex, name, memory, false);
        this.constantValueIndex = memory.readShortAsInt();
    }

    public int getConstantValueIndex() {
        return constantValueIndex;
    }
}
