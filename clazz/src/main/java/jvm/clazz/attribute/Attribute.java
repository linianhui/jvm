package jvm.clazz.attribute;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class Attribute {

    private final Clazz clazz;
    private final int nameIndex;
    private final int length;
    private final Memory memory;

    public Attribute(final Clazz clazz, final Memory memory) {
        this.clazz = clazz;
        this.nameIndex = memory.readShortAsInt();
        this.length = memory.readInt();
        this.memory = memory.slice(this.length);
    }

    public static Attribute[] from(final Clazz clazz, final Memory memory, int count) {
        final Attribute[] attributes = new Attribute[count];
        for (int i = 0; i < count; i++) {
            attributes[i] = new Attribute(clazz, memory);
        }
        return attributes;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public int getLength() {
        return length;
    }

    public Clazz getClazz() {
        return clazz;
    }
}
