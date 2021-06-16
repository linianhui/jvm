package jvm.clazz;

public abstract class Constant {
    private final byte tag;

    protected Constant(byte tag) {
        this.tag = tag;
    }

    public static Constant[] from(final Memory memory, int count) {
        final Constant[] constants = new Constant[count + 1];
        for (int i = 1; i <= count; i++) {
            //constants[i]= from(memory);
        }
        return constants;
    }

    private static Constant from(final Memory memory) {
        byte tag = memory.readByte();
        switch (tag) {
            case ConstantTag.Utf8:
                return new ConstantUtf8(memory);
            case ConstantTag.Integer:
                return new ConstantInteger(memory);
            case ConstantTag.Float:
                return new ConstantFloat(memory);
            case ConstantTag.Long:
                return new ConstantLong(memory);
            case ConstantTag.Double:
                return new ConstantDouble(memory);
            case ConstantTag.Class:
                return new ConstantClass(memory);
            case ConstantTag.String:
                return new ConstantString(memory);
            case ConstantTag.FieldRef:
                return new ConstantFieldRef(memory);
            case ConstantTag.MethodRef:
                return new ConstantMethodRef(memory);
            case ConstantTag.InterfaceMethodRef:
                return new ConstantInterfaceMethodRef(memory);
            case ConstantTag.NameAndType:
                return new ConstantNameAndType(memory);
            case ConstantTag.MethodHandle:
                return new ConstantMethodHandle(memory);
            case ConstantTag.MethodType:
                return new ConstantMethodType(memory);
            case ConstantTag.Dynamic:
                return new ConstantDynamic(memory);
            case ConstantTag.InvokeDynamic:
                return new ConstantInvokeDynamic(memory);
            case ConstantTag.Module:
                return new ConstantModule(memory);
            case ConstantTag.Package:
                return new ConstantPackage(memory);
        }
        throw new RuntimeException("unsupported tag " + tag);
    }

    public byte getTag() {
        return tag;
    }
}
