package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;

public class ParameterAnnotation {
    private final Clazz clazz;
    private final Annotations annotations;

    public ParameterAnnotation(final Clazz clazz, final Bytes bytes) {
        this.clazz = clazz;
        this.annotations = Annotations.from(clazz, bytes);
    }

    public Clazz getClazz() {
        return clazz;
    }

    public Annotations getAnnotations() {
        return annotations;
    }
}
