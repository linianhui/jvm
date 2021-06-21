package jvm.clazz.attribute;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class AttributeFactory {

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
            case Attribute.Name.LocalVariableTypeTable:
                return new LocalVariableTypeTableAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.RuntimeVisibleAnnotations:
                return new RuntimeVisibleAnnotationsAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.RuntimeInvisibleAnnotations:
                return new RuntimeInvisibleAnnotationsAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.RuntimeVisibleParameterAnnotations:
                return new RuntimeVisibleParameterAnnotationsAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.RuntimeInvisibleParameterAnnotations:
                return new RuntimeInvisibleParameterAnnotationsAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.AnnotationDefault:
                return new AnnotationDefaultAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.MethodParameters:
                return new MethodParametersAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.ModulePackages:
                return new ModulePackagesAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.ModuleMainClass:
                return new ModuleMainClassAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.NestHost:
                return new NestHostAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.NestMembers:
                return new NestMembersAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.Module:
                return new ModuleAttribute(clazz, nameIndex, name, bytes);
            case Attribute.Name.BootstrapMethods:
                return new BootstrapMethodsAttribute(clazz, nameIndex, name, bytes);
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
