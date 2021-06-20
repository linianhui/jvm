package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.7.27">ModuleMainClass Attribute</a>
 **/
public class ModuleMainClassAttribute extends Attribute {
    private final int mainClassIndex;

    protected ModuleMainClassAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        this.mainClassIndex = bytes.readShortAsInt();
    }

    public int getMainClassIndex() {
        return mainClassIndex;
    }
}
