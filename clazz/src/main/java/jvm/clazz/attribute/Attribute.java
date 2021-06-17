package jvm.clazz.attribute;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class Attribute {

    private final Clazz clazz;
    private final int nameIndex;
    private final String name;
    private final int length;

    protected Attribute(
        final Clazz clazz,
        final int nameIndex,
        final String name,
        final Memory memory,
        final boolean slice
    ) {
        this.clazz = clazz;
        this.nameIndex = nameIndex;
        this.name = name;
        this.length = memory.readInt();
        if (slice) {
            memory.slice(this.length);
        }
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

    public interface Name {
        String ConstantValue = "ConstantValue";
        String Signature = "Signature";
        String SourceFile = "SourceFile";
        String Deprecated = "Deprecated";
    }
}
