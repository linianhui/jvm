package jvm.clazz;

public class Interfaces extends Items<ClassIndex> {
    public Interfaces(final Clazz clazz, int count, ClassIndex[] items) {
        super(clazz, count, items);
    }

    public static Interfaces from(final Clazz clazz, final Bytes bytes) {
        int count = bytes.readShortAsInt();
        final ClassIndex[] items = new ClassIndex[count];
        for (int i = 0; i < count; i++) {
            items[i] = ClassIndex.form(clazz, bytes.readShortAsInt());
        }
        return new Interfaces(clazz, count, items);
    }
}
