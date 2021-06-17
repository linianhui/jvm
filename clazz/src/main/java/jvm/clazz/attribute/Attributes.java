package jvm.clazz.attribute;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class Attributes {
    private final int count;
    private final Attribute[] items;

    public Attributes(int count, Attribute[] items) {
        this.count = count;
        this.items = items;
    }

    public static Attributes from(final Clazz clazz, final Memory memory, int count) {
        final Attribute[] items = new Attribute[count];
        for (int i = 0; i < count; i++) {
            items[i] = new Attribute(clazz, memory);
        }
        return new Attributes(count, items);
    }

    public Attribute[] getItems() {
        return items;
    }

    public int getCount() {
        return count;
    }
}
