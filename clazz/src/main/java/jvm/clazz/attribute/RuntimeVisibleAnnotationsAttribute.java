package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.7.16">RuntimeVisibleAnnotations Attribute</a>
 **/
public class RuntimeVisibleAnnotationsAttribute extends Attribute {
    private final Annotations annotations;

    protected RuntimeVisibleAnnotationsAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        int count = bytes.readShortAsInt();
        this.annotations = Annotations.from(clazz, bytes, count);
    }

    public Annotations getAnnotations() {
        return annotations;
    }

}
