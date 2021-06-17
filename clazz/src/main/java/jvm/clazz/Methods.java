package jvm.clazz;

public class Methods {
    private final int count;
    private final Method[] items;

    public Methods(int count, Method[] items) {
        this.count = count;
        this.items = items;
    }

    public static Methods from(final Clazz clazz, final Memory memory, int count) {
        final Method[] items = new Method[count];
        for (int i = 0; i < count; i++) {
            items[i] = new Method(clazz, memory);
        }
        return new Methods(count, items);
    }

    public Method[] getItems() {
        return items;
    }

    public int getCount() {
        return count;
    }
}
