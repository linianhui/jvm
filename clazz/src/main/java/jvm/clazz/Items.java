package jvm.clazz;

public class Items<T> {
    private final Clazz clazz;
    private final int count;
    private final T[] items;

    public Items(final Clazz clazz, int count, T[] items) {
        this.clazz = clazz;
        this.count = count;
        this.items = items;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public int getCount() {
        return count;
    }

    public T get(int index) {
        return items[index];
    }
}
