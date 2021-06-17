package jvm.clazz;

public class Fields {
    private final int count;
    private final Field[] items;

    public Fields(int count, Field[] items) {
        this.count = count;
        this.items = items;
    }

    public static Fields from(final Clazz clazz, final Memory memory, int count) {
        final Field[] items = new Field[count];
        for (int i = 0; i < count; i++) {
            items[i] = new Field(clazz, memory);
        }
        return new Fields(count, items);
    }

    public Field[] getItems() {
        return items;
    }

    public int getCount() {
        return count;
    }
}
