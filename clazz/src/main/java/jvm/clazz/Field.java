package jvm.clazz;

import java.util.Set;

public class Field {
    private final Set<Integer> accessFlags;
    private final int nameIndex;
    private final int descriptorIndex;
    private final int attributesCount;
    private final Attribute[] attributes;

    public Field(final Memory memory) {
        this.accessFlags = FieldAccessFlag.in(memory.readShortAsInt());
        this.nameIndex = memory.readShortAsInt();
        this.descriptorIndex = memory.readShortAsInt();
        this.attributesCount = memory.readShortAsInt();
        this.attributes = Attribute.from(memory, attributesCount);
    }

    public static Field[] from(final Memory memory, int count) {
        final Field[] fields = new Field[count];
        for (int i = 0; i < count; i++) {
            fields[i] = new Field(memory);
        }
        return fields;
    }

    public Set<Integer> getAccessFlags() {
        return accessFlags;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public int getAttributesCount() {
        return attributesCount;
    }

    public Attribute[] getAttributes() {
        return attributes;
    }

    public int getNameIndex() {
        return nameIndex;
    }
}
