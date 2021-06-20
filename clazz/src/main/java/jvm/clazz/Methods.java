package jvm.clazz;

public class Methods extends Items<Method> {

    public Methods(final Clazz clazz, int count, Method[] items) {
        super(clazz, count, items);
    }

    public static Methods from(final Clazz clazz, final Bytes bytes) {
        int count = bytes.readShortAsInt();
        final Method[] items = new Method[count];
        for (int i = 0; i < count; i++) {
            items[i] = new Method(clazz, bytes);
        }
        return new Methods(clazz, count, items);
    }
}
