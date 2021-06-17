package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class PackageConstant extends Constant {
    private final int nameIndex;

    public PackageConstant(final Clazz clazz, final Bytes bytes) {
        super(clazz,Tag.Package);
        nameIndex = bytes.readShortAsInt();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}
