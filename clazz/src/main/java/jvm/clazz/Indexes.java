package jvm.clazz;


public class Indexes extends Items<Integer> {
    public Indexes(Clazz clazz, int count, Integer[] items) {
        super(clazz, count, items);
    }

    public static Indexes from(final Clazz clazz, final Bytes bytes) {
        int count = bytes.readShortAsInt();
        final Integer[] items = new Integer[count];
        for (int i = 0; i < count; i++) {
            items[i] = bytes.readShortAsInt();
        }
        return new Indexes(clazz, count, items);
    }
}