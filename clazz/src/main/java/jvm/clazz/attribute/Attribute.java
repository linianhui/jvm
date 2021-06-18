package jvm.clazz.attribute;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class Attribute {

    private final Clazz clazz;
    private final int nameIndex;
    private final String name;
    private final int length;

    protected Attribute(
        final Clazz clazz,
        final int nameIndex,
        final String name,
        final Bytes bytes,
        final boolean slice
    ) {
        this.clazz = clazz;
        this.nameIndex = nameIndex;
        this.name = name;
        this.length = bytes.readInt();
        if (slice) {
            bytes.slice(this.length);
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
        String Code = "Code";
    }
}
