package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.7.22">AnnotationDefault  Attribute</a>
 **/
public class AnnotationDefaultAttribute extends Attribute {
    private final ElementValue elementValue;

    protected AnnotationDefaultAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        this.elementValue = ElementValue.from(clazz, bytes);
    }

    public ElementValue getElementValue() {
        return elementValue;
    }
}
