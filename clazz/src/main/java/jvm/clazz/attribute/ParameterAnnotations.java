package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;
import jvm.clazz.Items;

public class ParameterAnnotations extends Items<ParameterAnnotation> {
    public ParameterAnnotations(Clazz clazz, int count, ParameterAnnotation[] items) {
        super(clazz, count, items);
    }

    public static ParameterAnnotations from(final Clazz clazz, final Bytes bytes) {
        int count = bytes.readByteAsInt();
        final ParameterAnnotation[] items = new ParameterAnnotation[count];
        for (int i = 0; i < count; i++) {
            items[i] = new ParameterAnnotation(clazz, bytes);
        }
        return new ParameterAnnotations(clazz, count, items);
    }
}
