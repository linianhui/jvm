package jvm.clazz.attribute;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class SourceFileAttribute extends Attribute {
    private final int sourceFileIndex;

    protected SourceFileAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        this.sourceFileIndex = bytes.readShortAsInt();
    }

    public int getSourceFileIndex() {
        return sourceFileIndex;
    }
}
