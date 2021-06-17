package jvm.clazz.attribute;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class SignatureAttribute extends Attribute {
    private final int signatureIndex;

    protected SignatureAttribute(final Clazz clazz, int nameIndex, String name, Memory memory) {
        super(clazz, nameIndex, name, memory, false);
        this.signatureIndex = memory.readShortAsInt();
    }

    public int getSignatureIndex() {
        return signatureIndex;
    }
}
