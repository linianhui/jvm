package jvm.clazz;

public class ConstantPackage extends Constant {
    private final int nameIndex;

    public ConstantPackage(final Memory memory) {
        super(ConstantTag.Package);
        nameIndex = memory.readShortAsInt();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}
