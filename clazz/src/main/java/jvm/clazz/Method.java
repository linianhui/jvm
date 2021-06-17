package jvm.clazz;

import java.util.Set;

public class Method {
    private final Set<Integer> accessFlags;
    private final int nameIndex;
    private final int descriptorIndex;
    private final int attributesCount;
    private final Attribute[] attributes;

    public Method(final Memory memory) {
        this.accessFlags = MethodAccessFlag.in(memory.readShortAsInt());
        this.nameIndex = memory.readShortAsInt();
        this.descriptorIndex = memory.readShortAsInt();
        this.attributesCount = memory.readShortAsInt();
        this.attributes = Attribute.from(memory, attributesCount);
    }

    public static Method[] from(final Memory memory, int count) {
        final Method[] methods = new Method[count];
        for (int i = 0; i < count; i++) {
            methods[i] = new Method(memory);
        }
        return methods;
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
