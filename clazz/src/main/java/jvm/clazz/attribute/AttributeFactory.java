package jvm.clazz.attribute;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class AttributeFactory {
    public static Attributes from(final Clazz clazz, final Memory memory, int count) {
        final Attribute[] items = new Attribute[count];
        for (int i = 0; i < count; i++) {
            items[i] = from(clazz, memory);
        }
        return new Attributes(clazz, count, items);
    }

    public static Attribute from(final Clazz clazz, final Memory memory) {
        int nameIndex = memory.readShortAsInt();
        String name = findName(clazz, nameIndex);
        if (name==null) {
            return new Attribute(clazz, nameIndex, name, memory, true);
        }
        switch (name) {
            case Attribute.Name.ConstantValue:
                return new ConstantValueAttribute(clazz, nameIndex, name, memory);
            case Attribute.Name.Signature:
                return new SignatureAttribute(clazz, nameIndex, name, memory);
            case Attribute.Name.SourceFile:
                return new SourceFileAttribute(clazz, nameIndex, name, memory);
            case Attribute.Name.Deprecated:
                return new DeprecatedAttribute(clazz, nameIndex, name, memory);
            default:
                return new Attribute(clazz, nameIndex, name, memory, true);
        }
    }

    private static String findName(final Clazz clazz, int nameIndex) {
        if (clazz==null) {
            return null;
        }
        return clazz.getConstants().getUTF8String(nameIndex);
    }
}
