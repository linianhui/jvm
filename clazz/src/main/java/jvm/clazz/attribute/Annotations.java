package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;
import jvm.clazz.Items;

public class Annotations extends Items<Annotation> {
    public Annotations(Clazz clazz, int count, Annotation[] items) {
        super(clazz, count, items);
    }

    public static Annotations from(final Clazz clazz, final Bytes bytes) {
        int count = bytes.readShortAsInt();
        final Annotation[] items = new Annotation[count];
        for (int i = 0; i < count; i++) {
            items[i] = new Annotation(clazz, bytes);
        }
        return new Annotations(clazz, count, items);
    }
}
