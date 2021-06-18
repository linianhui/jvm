package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;
import jvm.clazz.Items;

public class ExceptionsAttribute extends Attribute {
    private final Exceptions exceptions;

    protected ExceptionsAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        int exceptionsCount = bytes.readShortAsInt();
        this.exceptions = Exceptions.from(clazz, bytes, exceptionsCount);
    }

    public Exceptions getExceptions() {
        return exceptions;
    }

    public static class Exceptions extends Items<Integer> {
        public Exceptions(final Clazz clazz, int count, Integer[] items) {
            super(clazz, count, items);
        }

        public static Exceptions from(final Clazz clazz, final Bytes bytes, int count) {
            final Integer[] items = new Integer[count];
            for (int i = 0; i < count; i++) {
                items[i] = bytes.readShortAsInt();
            }
            return new Exceptions(clazz, count, items);
        }
    }
}
