package jvm.clazz;

public abstract class Constant {
    private final byte tag;

    protected Constant(byte tag) {
        this.tag = tag;
    }

    public static Constant[] from(final Memory memory, int count) {
        final Constant[] constants = new Constant[count + 1];
        for (int i = 1; i < count; i++) {
            byte tag = memory.readByte();
            constants[i] = from(memory, tag);
            if (tag == Tag.Double || tag == Tag.Long) {
                i++;
            }
        }
        return constants;
    }

    private static Constant from(final Memory memory, byte tag) {

        switch (tag) {
            case Tag.Utf8:
                return new ConstantUtf8(memory);
            case Tag.Integer:
                return new ConstantInteger(memory);
            case Tag.Float:
                return new ConstantFloat(memory);
            case Tag.Long:
                return new ConstantLong(memory);
            case Tag.Double:
                return new ConstantDouble(memory);
            case Tag.Class:
                return new ConstantClass(memory);
            case Tag.String:
                return new ConstantString(memory);
            case Tag.FieldRef:
                return new ConstantFieldRef(memory);
            case Tag.MethodRef:
                return new ConstantMethodRef(memory);
            case Tag.InterfaceMethodRef:
                return new ConstantInterfaceMethodRef(memory);
            case Tag.NameAndType:
                return new ConstantNameAndType(memory);
            case Tag.MethodHandle:
                return new ConstantMethodHandle(memory);
            case Tag.MethodType:
                return new ConstantMethodType(memory);
            case Tag.Dynamic:
                return new ConstantDynamic(memory);
            case Tag.InvokeDynamic:
                return new ConstantInvokeDynamic(memory);
            case Tag.Module:
                return new ConstantModule(memory);
            case Tag.Package:
                return new ConstantPackage(memory);
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
    }
}
