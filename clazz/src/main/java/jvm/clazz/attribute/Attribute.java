package jvm.clazz.attribute;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class Attribute {

    private final Clazz clazz;
    private final int nameIndex;
    private final String name;
    private final int length;
    private final Memory memory;

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
            this.memory = memory.slice(this.length);
        } else {
            this.memory = memory;
        }
    }

    public static Attribute from(final Clazz clazz, final Memory memory) {
        int nameIndex = memory.readShortAsInt();
        String name = findName(clazz, nameIndex);
        if (name == null) {
            return new Attribute(clazz, nameIndex, name, memory, true);
        }
        switch (name) {
            case Name.ConstantValue:
                return new ConstantValueAttribute(clazz, nameIndex, name, memory);
            case Name.Signature:
                return new SignatureAttribute(clazz, nameIndex, name, memory);
            case Name.SourceFile:
                return new SourceFileAttribute(clazz, nameIndex, name, memory);
            case Name.Deprecated:
                return new DeprecatedAttribute(clazz, nameIndex, name, memory);
            default:
                return new Attribute(clazz, nameIndex, name, memory, true);
        }
    }

    public static String findName(final Clazz clazz, int nameIndex) {
        if (clazz == null) {
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

    protected Memory getMemory() {
        return memory;
    }

    public interface Name {
        String ConstantValue = "ConstantValue";
        String Signature = "Signature";
        String SourceFile = "SourceFile";
        String Deprecated = "Deprecated";
    }
}
