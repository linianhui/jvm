package jvm.clazz.attribute;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class DeprecatedAttribute extends Attribute {
    protected DeprecatedAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
    }
}
