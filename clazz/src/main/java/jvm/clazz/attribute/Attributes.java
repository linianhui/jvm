package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;
import jvm.clazz.Items;

public class Attributes extends Items<Attribute> {
    public Attributes(Clazz clazz, int count, Attribute[] items) {
        super(clazz, count, items);
    }

    public static Attributes from(final Clazz clazz, final Bytes bytes) {
        int count = bytes.readShortAsInt();
        final Attribute[] items = new Attribute[count];
        for (int i = 0; i < count; i++) {
            items[i] = AttributeFactory.from(clazz, bytes);
        }
        return new Attributes(clazz, count, items);
    }
}
