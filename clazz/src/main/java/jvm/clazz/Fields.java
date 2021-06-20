package jvm.clazz;

public class Fields extends Items<Field> {

    public Fields(final Clazz clazz, int count, Field[] items) {
        super(clazz, count, items);
    }

    public static Fields from(final Clazz clazz, final Bytes bytes) {
        int count = bytes.readShortAsInt();
        final Field[] items = new Field[count];
        for (int i = 0; i < count; i++) {
            items[i] = new Field(clazz, bytes);
        }
        return new Fields(clazz, count, items);
    }
}
