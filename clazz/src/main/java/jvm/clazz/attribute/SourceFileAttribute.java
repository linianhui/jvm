package jvm.clazz.attribute;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class SourceFileAttribute extends Attribute {
    private final int sourceFileIndex;

    protected SourceFileAttribute(final Clazz clazz, int nameIndex, String name, Memory memory) {
        super(clazz, nameIndex, name, memory, false);
        this.sourceFileIndex = memory.readShortAsInt();
    }

    public int getSourceFileIndex() {
        return sourceFileIndex;
    }
}
