package jvm.clazz;

public class Interfaces extends Items<Integer> {
    public Interfaces(final Clazz clazz, int count, Integer[] items) {
        super(clazz, count, items);
    }

    public static Interfaces from(final Clazz clazz, final Memory memory, int count) {
        final Integer[] items = new Integer[count];
        for (int i = 0; i < count; i++) {
            items[i] = memory.readShortAsInt();
        }
        return new Interfaces(clazz, count, items);
    }
}
