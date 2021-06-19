package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;

public class SyntheticAttribute extends Attribute {
    protected SyntheticAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
    }
}
