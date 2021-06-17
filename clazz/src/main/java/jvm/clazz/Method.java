package jvm.clazz;

import java.util.HashSet;
import java.util.Set;

import jvm.clazz.attribute.Attribute;
import jvm.clazz.util.BitUtil;

public class Method {
    private final Clazz clazz;
    private final Set<Integer> accessFlags;
    private final int nameIndex;
    private final int descriptorIndex;
    private final int attributesCount;
    private final Attribute[] attributes;

    public Method(final Clazz clazz, final Memory memory) {
        this.clazz = clazz;
        this.accessFlags = AccessFlag.in(memory.readShortAsInt());
        this.nameIndex = memory.readShortAsInt();
        this.descriptorIndex = memory.readShortAsInt();
        this.attributesCount = memory.readShortAsInt();
        this.attributes = Attribute.from(clazz, memory, attributesCount);
    }

    public static Method[] from(final Clazz clazz, final Memory memory, int count) {
        final Method[] methods = new Method[count];
        for (int i = 0; i < count; i++) {
            methods[i] = new Method(clazz, memory);
        }
        return methods;
    }

    public Set<Integer> getAccessFlags() {
        return accessFlags;
    }

    public int getNameIndex() {
        return nameIndex;
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

    public Clazz getClazz() {
        return clazz;
    }

    public interface AccessFlag {
        int Public = 0x00_01;
        int Private = 0x00_02;
        int Protected = 0x00_04;
        int Static = 0x00_08;
        int Final = 0x00_10;
        int Synchronized = 0x00_20;
        int Bridge = 0x00_40;
        int Varargs = 0x00_80;
        int Native = 0x01_00;
        int Abstract = 0x04_00;
        int Strict = 0x08_00;
        int Synthetic = 0x10_00;

        Set<Integer> ALL = new HashSet<>() {{
            this.add(Public);
            this.add(Private);
            this.add(Protected);
            this.add(Static);
            this.add(Final);
            this.add(Synchronized);
            this.add(Bridge);
            this.add(Varargs);
            this.add(Native);
            this.add(Abstract);
            this.add(Strict);
            this.add(Synthetic);
        }};

        static Set<Integer> in(int value) {
            return BitUtil.in(ALL, value);
        }
    }
}
