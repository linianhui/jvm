package jvm.clazz;

import java.util.Set;

public class ClassFile {
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


    public ClassFile(final Memory memory) {
        this.magic = memory.readInt();
        this.minorVersion = memory.readShortAsInt();
        this.majorVersion = memory.readShortAsInt();
        this.constantPoolCount = memory.readShortAsInt();
        this.constantPool = Constant.from(memory, this.constantPoolCount);
        this.accessFlags = ClassAccessFlag.from(memory.readShortAsInt());
        this.thisClass = memory.readShortAsInt();
        this.superClass = memory.readShortAsInt();
        this.interfacesCount = memory.readShortAsInt();
        this.interfaces = memory.readShortAsInts(this.interfacesCount);
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
}
