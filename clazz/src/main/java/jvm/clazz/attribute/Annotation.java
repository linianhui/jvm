package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;

public class Annotation {
    private final Clazz clazz;
    private final int typeIndex;
    private final ElementValuePairs elementValuePairs;

    public Annotation(final Clazz clazz, final Bytes bytes) {
        this.clazz = clazz;
        this.typeIndex = bytes.readShortAsInt();
        this.elementValuePairs = ElementValuePairs.from(clazz, bytes);
    }

    public Clazz getClazz() {
        return clazz;
    }

    public int getTypeIndex() {
        return typeIndex;
    }

    public ElementValuePairs getElementValuePairs() {
        return elementValuePairs;
    }
}
