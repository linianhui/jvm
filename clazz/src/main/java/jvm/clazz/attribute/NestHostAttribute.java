package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.7.28">NestHost Attribute</a>
 **/
public class NestHostAttribute extends Attribute {
    private final int hostClassIndex;

    protected NestHostAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        this.hostClassIndex = bytes.readShortAsInt();
    }

    public int getHostClassIndex() {
        return hostClassIndex;
    }
}
