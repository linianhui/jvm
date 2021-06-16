package jvm.clazz;

public class ClassFile {
    private int magic;
    private int minorVersion;
    private int majorVersion;
    private int constantPoolCount;
    private Constant[] constantPool;

    public ClassFile(final Memory memory) {
        this.magic = memory.readInt();
        this.minorVersion = memory.readShortAsInt();
        this.majorVersion = memory.readShortAsInt();
        this.constantPoolCount = memory.readShortAsInt();
        this.constantPool = Constant.from(memory, this.constantPoolCount);
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
}
