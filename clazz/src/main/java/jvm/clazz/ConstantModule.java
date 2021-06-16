package jvm.clazz;

public class ConstantModule extends Constant {
    private final int nameIndex;

    public ConstantModule(final Memory memory) {
        super(ConstantTag.Module);
        nameIndex = memory.readShortAsInt();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}
