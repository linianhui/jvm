package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;

public class EnclosingMethodAttribute extends Attribute {
    private final int classIndex;
    private final int methodIndex;

    protected EnclosingMethodAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        this.classIndex = bytes.readShortAsInt();
        this.methodIndex = bytes.readShortAsInt();
    }

    public int getClassIndex() {
        return classIndex;
    }

    public int getMethodIndex() {
        return methodIndex;
    }
}
