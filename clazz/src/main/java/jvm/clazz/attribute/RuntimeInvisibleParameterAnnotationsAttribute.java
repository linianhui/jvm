package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.7.19">RuntimeInvisibleParameterAnnotations Attribute</a>
 **/
public class RuntimeInvisibleParameterAnnotationsAttribute extends Attribute {
    private final ParameterAnnotations annotations;

    protected RuntimeInvisibleParameterAnnotationsAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        this.annotations = ParameterAnnotations.from(clazz, bytes);
    }

    public ParameterAnnotations getAnnotations() {
        return annotations;
    }

}
