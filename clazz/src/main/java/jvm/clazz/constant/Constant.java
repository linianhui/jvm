package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public abstract class Constant {
    private final Clazz clazz;
    private final byte tag;

    protected Constant(final Clazz clazz, byte tag) {
        this.clazz = clazz;
        this.tag = tag;
    }

    public static Constant from(final Clazz clazz, final Memory memory, byte tag) {

        switch (tag) {
            case Tag.Utf8:
                return new UTF8Constant(clazz, memory);
            case Tag.Integer:
                return new IntegerConstant(clazz, memory);
            case Tag.Float:
                return new FloatConstant(clazz, memory);
            case Tag.Long:
                return new LongConstant(clazz, memory);
            case Tag.Double:
                return new DoubleConstant(clazz, memory);
            case Tag.Class:
                return new ClassConstant(clazz, memory);
            case Tag.String:
                return new StringConstant(clazz, memory);
            case Tag.FieldRef:
                return new FieldRefConstant(clazz, memory);
            case Tag.MethodRef:
                return new MethodRefConstant(clazz, memory);
            case Tag.InterfaceMethodRef:
                return new InterfaceMethodRefConstant(clazz, memory);
            case Tag.NameAndType:
                return new NameAndTypeConstant(clazz, memory);
            case Tag.MethodHandle:
                return new MethodHandleConstant(clazz, memory);
            case Tag.MethodType:
                return new MethodTypeConstant(clazz, memory);
            case Tag.Dynamic:
                return new DynamicConstant(clazz, memory);
            case Tag.InvokeDynamic:
                return new InvokeDynamicConstant(clazz, memory);
            case Tag.Module:
                return new ModuleConstant(clazz, memory);
            case Tag.Package:
                return new PackageConstant(clazz, memory);
        }
        throw new RuntimeException("unsupported tag " + tag);
    }

    public Clazz getClazz() {
        return clazz;
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
