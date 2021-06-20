package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;
import jvm.clazz.Items;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.7.29">NestMembers Attribute</a>
 **/
public class NestMembersAttribute extends Attribute {
    private final Classes classes;

    protected NestMembersAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        this.classes = Classes.from(clazz, bytes);
    }

    public Classes getClasses() {
        return classes;
    }

    public static class Classes extends Items<Integer> {
        public Classes(final Clazz clazz, int count, Integer[] items) {
            super(clazz, count, items);
        }

        public static Classes from(final Clazz clazz, final Bytes bytes) {
            int count = bytes.readShortAsInt();
            final Integer[] items = new Integer[count];
            for (int i = 0; i < count; i++) {
                items[i] = bytes.readShortAsInt();
            }
            return new Classes(clazz, count, items);
        }
    }
}
