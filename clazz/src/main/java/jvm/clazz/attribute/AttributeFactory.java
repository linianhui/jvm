package jvm.clazz.attribute;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class AttributeFactory {
    public static Attributes from(final Clazz clazz, final Bytes bytes, int count) {
        final Attribute[] items = new Attribute[count];
        for (int i = 0; i < count; i++) {
            items[i] = from(clazz, bytes);
        }
        return new Attributes(clazz, count, items);
    }

    public static Attribute from(final Clazz clazz, final Bytes bytes) {
        int nameIndex = bytes.readShortAsInt();
        String name = findName(clazz, nameIndex);
        if (name==null) {
            return new Attribute(clazz, nameIndex, name, bytes, true);
        }
        switch (name) {
            case Attribute.Name.ConstantValue:
                return new ConstantValueAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.Signature:
                return new SignatureAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.SourceFile:
                return new SourceFileAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.Deprecated:
                return new DeprecatedAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.Code:
                return new CodeAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.Exceptions:
                return new ExceptionsAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.LineNumberTable:
                return new LineNumberTableAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.LocalVariableTable:
                return new LocalVariableTableAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.InnerClasses:
                return new InnerClassesAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.Synthetic:
                return new SyntheticAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.EnclosingMethod:
                return new EnclosingMethodAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.SourceDebugExtension:
                return new SourceDebugExtensionAttribute(clazz, nameIndex, name, bytes);
            default:
                return new Attribute(clazz, nameIndex, name, bytes, true);
        }
    }

    private static String findName(final Clazz clazz, int nameIndex) {
        if (clazz==null) {
            return null;
        }
        return clazz.getConstants().getUTF8String(nameIndex);
    }
}
