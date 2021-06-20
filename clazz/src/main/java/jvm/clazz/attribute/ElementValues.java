package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;
import jvm.clazz.Items;


public class ElementValues extends Items<ElementValue> {
    public ElementValues(Clazz clazz, int count, ElementValue[] items) {
        super(clazz, count, items);
    }

    public static ElementValues from(final Clazz clazz, final Bytes bytes) {
        final int count = bytes.readShortAsInt();
        final ElementValue[] items = new ElementValue[count];
        for (int i = 0; i < count; i++) {
            items[i] = new ElementValue(clazz, bytes);
        }
        return new ElementValues(clazz, count, items);
    }
}
