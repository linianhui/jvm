package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;

public class ElementValuePair {
    private final Clazz clazz;
    private final int nameIndex;
    private final ElementValue value;

    protected ElementValuePair(final Clazz clazz, final Bytes bytes) {
        this.clazz = clazz;
        this.nameIndex = bytes.readShortAsInt();
        this.value = ElementValue.from(clazz, bytes);
    }

    public Clazz getClazz() {
        return clazz;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public ElementValue getValue() {
        return value;
    }
}
