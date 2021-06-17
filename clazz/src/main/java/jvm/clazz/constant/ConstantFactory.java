package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Memory;

public class ConstantFactory {
    public static Constants from(final Clazz clazz, final Memory memory, int count) {
        final Constant[] items = new Constant[count + 1];
        for (int i = 1; i < count; i++) {
            byte tag = memory.readByte();
            items[i] = from(clazz, memory, tag);
            if (Constant.Tag.as2Constant(tag)) {
                i++;
            }
        }
        return new Constants(clazz, count, items);
    }

    public static Constant from(final Clazz clazz, final Memory memory, byte tag) {

        switch (tag) {
            case Constant.Tag.Utf8:
                return new UTF8Constant(clazz, memory);
            case Constant.Tag.Integer:
                return new IntegerConstant(clazz, memory);
            case Constant.Tag.Float:
                return new FloatConstant(clazz, memory);
            case Constant.Tag.Long:
                return new LongConstant(clazz, memory);
            case Constant.Tag.Double:
                return new DoubleConstant(clazz, memory);
            case Constant.Tag.Class:
                return new ClassConstant(clazz, memory);
            case Constant.Tag.String:
                return new StringConstant(clazz, memory);
            case Constant.Tag.FieldRef:
                return new FieldRefConstant(clazz, memory);
            case Constant.Tag.MethodRef:
                return new MethodRefConstant(clazz, memory);
            case Constant.Tag.InterfaceMethodRef:
                return new InterfaceMethodRefConstant(clazz, memory);
            case Constant.Tag.NameAndType:
                return new NameAndTypeConstant(clazz, memory);
            case Constant.Tag.MethodHandle:
                return new MethodHandleConstant(clazz, memory);
            case Constant.Tag.MethodType:
                return new MethodTypeConstant(clazz, memory);
            case Constant.Tag.Dynamic:
                return new DynamicConstant(clazz, memory);
            case Constant.Tag.InvokeDynamic:
                return new InvokeDynamicConstant(clazz, memory);
            case Constant.Tag.Module:
                return new ModuleConstant(clazz, memory);
            case Constant.Tag.Package:
                return new PackageConstant(clazz, memory);
        }
        throw new RuntimeException("unsupported tag " + tag);
    }
}
