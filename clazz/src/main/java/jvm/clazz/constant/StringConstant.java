package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class StringConstant extends Constant {
    private final int stringIndex;

    public StringConstant(final Clazz clazz, final Memory memory) {
        super(clazz,Tag.String);
        stringIndex = memory.readShortAsInt();
    }

    public int getNameIndex() {
        return stringIndex;
    }
}
