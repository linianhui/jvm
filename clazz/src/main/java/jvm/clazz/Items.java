package jvm.clazz;

public class Items<T> extends ClazzAccessor {
    private final int count;
    private final T[] items;

    public Items(final Clazz clazz, int count, T[] items) {
        super(clazz);
        this.count = count;
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public T get(int index) {
        return items[index];
    }
}
