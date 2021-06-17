package jvm.clazz;

import java.util.HashSet;
import java.util.Set;

import jvm.clazz.util.BitUtil;

public class Clazz {
    private final int magic;
    private final int minorVersion;
    private final int majorVersion;
    private final int constantPoolCount;
    private final Constant[] constantPool;
    private final Set<Integer> accessFlags;
    private final int thisClass;
    private final int superClass;
    private final int interfacesCount;
    private final int[] interfaces;
    private final int fieldsCount;
    private final Field[] fields;
    private final int methodsCount;
    private final Method[] methods;
    private final int attributesCount;
    private final Attribute[] attributes;

    public Clazz(final Memory memory) {
        this.magic = memory.readInt();
        this.minorVersion = memory.readShortAsInt();
        this.majorVersion = memory.readShortAsInt();
        this.constantPoolCount = memory.readShortAsInt();
        this.constantPool = Constant.from(memory, this.constantPoolCount);
        this.accessFlags = AccessFlag.in(memory.readShortAsInt());
        this.thisClass = memory.readShortAsInt();
        this.superClass = memory.readShortAsInt();
        this.interfacesCount = memory.readShortAsInt();
        this.interfaces = memory.readShortAsInts(this.interfacesCount);
        this.fieldsCount = memory.readShortAsInt();
        this.fields = Field.from(memory, this.fieldsCount);
        this.methodsCount = memory.readShortAsInt();
        this.methods = Method.from(memory, this.methodsCount);
        this.attributesCount = memory.readShortAsInt();
        this.attributes = Attribute.from(memory, this.attributesCount);
    }

    public int getMagic() {
        return magic;
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public int getConstantPoolCount() {
        return constantPoolCount;
    }

    public Constant[] getConstantPool() {
        return constantPool;
    }

    public Set<Integer> getAccessFlags() {
        return accessFlags;
    }

    public int getThisClass() {
        return thisClass;
    }

    public int getSuperClass() {
        return superClass;
    }

    public int getInterfacesCount() {
        return interfacesCount;
    }

    public int[] getInterfaces() {
        return interfaces;
    }

    public int getFieldsCount() {
        return fieldsCount;
    }

    public Field[] getFields() {
        return fields;
    }

    public int getMethodsCount() {
        return methodsCount;
    }

    public Method[] getMethods() {
        return methods;
    }

    public int getAttributesCount() {
        return attributesCount;
    }

    public Attribute[] getAttributes() {
        return attributes;
    }

    public interface AccessFlag {
        int Public = 0x00_01;
        int Final = 0x00_10;
        int Super = 0x00_20;
        int Interface = 0x02_00;
        int Abstract = 0x04_00;
        int Synthetic = 0x10_00;
        int Annotation = 0x20_00;
        int Enum = 0x40_00;
        int Module = 0x80_00;

        Set<Integer> ALL = new HashSet<>() {{
            this.add(Public);
            this.add(Final);
            this.add(Super);
            this.add(Interface);
            this.add(Abstract);
            this.add(Synthetic);
            this.add(Annotation);
            this.add(Enum);
            this.add(Module);
        }};

        static Set<Integer> in(int value) {
            return BitUtil.in(ALL, value);
        }
    }
}
