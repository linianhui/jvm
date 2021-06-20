package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;
import jvm.clazz.Items;


public class ElementValuePairs extends Items<ElementValuePair> {
    public ElementValuePairs(Clazz clazz, int count, ElementValuePair[] items) {
        super(clazz, count, items);
    }

    public static ElementValuePairs from(final Clazz clazz, final Bytes bytes) {
        int count = bytes.readShortAsInt();
        final ElementValuePair[] items = new ElementValuePair[count];
        for (int i = 0; i < count; i++) {
            items[i] = new ElementValuePair(clazz, bytes);
        }
        return new ElementValuePairs(clazz, count, items);
    }
}
