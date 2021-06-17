package jvm.clazz.attribute;

import jvm.clazz.Clazz;
import jvm.clazz.Items;
import jvm.clazz.Memory;

public class Attributes extends Items<Attribute> {
    public Attributes(Clazz clazz, int count, Attribute[] items) {
        super(clazz, count, items);
    }

    public static Attributes from(final Clazz clazz, final Memory memory, int count) {
        final Attribute[] items = new Attribute[count];
        for (int i = 0; i < count; i++) {
            items[i] = new Attribute(clazz, memory);
        }
        return new Attributes(clazz, count, items);
    }
}
