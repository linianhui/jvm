package jvm.clazz.attribute;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class SignatureAttribute extends Attribute {
    private final int signatureIndex;

    protected SignatureAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        this.signatureIndex = bytes.readShortAsInt();
    }

    public int getSignatureIndex() {
        return signatureIndex;
    }
}
