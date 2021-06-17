package jvm.clazz;

public class Interfaces {
    private final Clazz clazz;
    private final int count;
    private final int[] items;

    public Interfaces(final Clazz clazz, int count, int[] items) {
        this.clazz = clazz;
        this.count = count;
        this.items = items;
    }

    public static Interfaces from(final Clazz clazz, final Memory memory, int count) {
        final int[] items = new int[count];
        for (int i = 0; i < count; i++) {
            items[i] = memory.readShortAsInt();
        }
        return new Interfaces(clazz, count, items);
    }

    public Clazz getClazz() {
        return clazz;
    }

    public int[] getItems() {
        return items;
    }

    public int getCount() {
        return count;
    }
}
