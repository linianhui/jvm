package jvm.clazz.attribute;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class ConstantValueAttribute extends Attribute {
    private final int constantValueIndex;

    protected ConstantValueAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        this.constantValueIndex = bytes.readShortAsInt();
    }

    public int getConstantValueIndex() {
        return constantValueIndex;
    }
}
