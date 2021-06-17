package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class StringConstant extends Constant {
    private final int stringIndex;

    public StringConstant(final Clazz clazz, final Bytes bytes) {
        super(clazz,Tag.String);
        stringIndex = bytes.readShortAsInt();
    }

    public int getNameIndex() {
        return stringIndex;
    }
}
