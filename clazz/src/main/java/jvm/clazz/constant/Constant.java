package jvm.clazz.constant;

import jvm.clazz.Memory;

public abstract class Constant {
    private final byte tag;

    protected Constant(byte tag) {
        this.tag = tag;
    }

    public static Constant from(final Memory memory, byte tag) {

        switch (tag) {
            case Tag.Utf8:
                return new UTF8Constant(memory);
            case Tag.Integer:
                return new IntegerConstant(memory);
            case Tag.Float:
                return new FloatConstant(memory);
            case Tag.Long:
                return new LongConstant(memory);
            case Tag.Double:
                return new DoubleConstant(memory);
            case Tag.Class:
                return new ClassConstant(memory);
            case Tag.String:
                return new StringConstant(memory);
            case Tag.FieldRef:
                return new FieldRefConstant(memory);
            case Tag.MethodRef:
                return new MethodRefConstant(memory);
            case Tag.InterfaceMethodRef:
                return new InterfaceMethodRefConstant(memory);
            case Tag.NameAndType:
                return new NameAndTypeConstant(memory);
            case Tag.MethodHandle:
                return new MethodHandleConstant(memory);
            case Tag.MethodType:
                return new MethodTypeConstant(memory);
            case Tag.Dynamic:
                return new DynamicConstant(memory);
            case Tag.InvokeDynamic:
                return new InvokeDynamicConstant(memory);
            case Tag.Module:
                return new ModuleConstant(memory);
            case Tag.Package:
                return new PackageConstant(memory);
        }
        throw new RuntimeException("unsupported tag " + tag);
    }

    public byte getTag() {
        return tag;
    }

    public interface Tag {
        byte Utf8 = 1;
        byte Integer = 3;
        byte Float = 4;
        byte Long = 5;
        byte Double = 6;
        byte Class = 7;
        byte String = 8;
        byte FieldRef = 9;
        byte MethodRef = 10;
        byte InterfaceMethodRef = 11;
        byte NameAndType = 12;
        byte MethodHandle = 15;
        byte MethodType = 16;
        byte Dynamic = 17;
        byte InvokeDynamic = 18;
        byte Module = 19;
        byte Package = 20;

        static boolean as2Constant(byte tag) {
            return tag==Double || tag==Long;
        }
    }
}
