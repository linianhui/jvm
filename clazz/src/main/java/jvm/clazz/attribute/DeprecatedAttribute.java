package jvm.clazz.attribute;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class DeprecatedAttribute extends Attribute {
    protected DeprecatedAttribute(final Clazz clazz, int nameIndex, String name, Memory memory) {
        super(clazz, nameIndex, name, memory, false);
    }
}
