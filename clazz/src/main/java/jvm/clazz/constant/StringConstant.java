package jvm.clazz.constant;

import jvm.clazz.Memory;

public class StringConstant extends Constant {
    private final int stringIndex;

    public StringConstant(final Memory memory) {
        super(Tag.String);
        stringIndex = memory.readShortAsInt();
    }

    public int getNameIndex() {
        return stringIndex;
    }
}
