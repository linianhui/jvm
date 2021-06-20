package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.7.17">RuntimeInvisibleAnnotations Attribute</a>
 **/
public class RuntimeInvisibleAnnotationsAttribute extends Attribute {
    private final Annotations annotations;

    protected RuntimeInvisibleAnnotationsAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        this.annotations = Annotations.from(clazz, bytes);
    }

    public Annotations getAnnotations() {
        return annotations;
    }

}
