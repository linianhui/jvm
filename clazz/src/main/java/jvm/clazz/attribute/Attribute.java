package jvm.clazz.attribute;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class Attribute {

    private final Clazz clazz;
    private final int nameIndex;
    private final String name;
    private final int length;
    private final Memory memory;

    protected Attribute(final Clazz clazz, final int nameIndex, String name, final Memory memory) {
        this.clazz = clazz;
        this.nameIndex = nameIndex;
        this.name = name;
        this.length = memory.readInt();
        this.memory = memory.slice(this.length);
    }

    public static Attribute from(final Clazz clazz, final Memory memory) {
        int nameIndex = memory.readShortAsInt();
        String name = findName(clazz, nameIndex);
        return new Attribute(clazz, nameIndex, name, memory);
    }

    public static String findName(final Clazz clazz, int nameIndex) {
        if (clazz==null) {
            return null;
        }
        return clazz.getConstants().getUTF8String(nameIndex);
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public Clazz getClazz() {
        return clazz;
    }
}
