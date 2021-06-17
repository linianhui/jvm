package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Bytes;

public class ConstantFactory {
    public static Constants from(final Clazz clazz, final Bytes bytes, int count) {
        final Constant[] items = new Constant[count + 1];
        for (int i = 1; i < count; i++) {
            byte tag = bytes.readByte();
            items[i] = from(clazz, bytes, tag);
            if (Constant.Tag.as2Constant(tag)) {
                i++;
            }
        }
        return new Constants(clazz, count, items);
    }

    public static Constant from(final Clazz clazz, final Bytes bytes, byte tag) {

        switch (tag) {
            case Constant.Tag.Utf8:
                return new UTF8Constant(clazz, bytes);
            case Constant.Tag.Integer:
                return new IntegerConstant(clazz, bytes);
            case Constant.Tag.Float:
                return new FloatConstant(clazz, bytes);
            case Constant.Tag.Long:
                return new LongConstant(clazz, bytes);
            case Constant.Tag.Double:
                return new DoubleConstant(clazz, bytes);
            case Constant.Tag.Class:
                return new ClassConstant(clazz, bytes);
            case Constant.Tag.String:
                return new StringConstant(clazz, bytes);
            case Constant.Tag.FieldRef:
                return new FieldRefConstant(clazz, bytes);
            case Constant.Tag.MethodRef:
                return new MethodRefConstant(clazz, bytes);
            case Constant.Tag.InterfaceMethodRef:
                return new InterfaceMethodRefConstant(clazz, bytes);
            case Constant.Tag.NameAndType:
                return new NameAndTypeConstant(clazz, bytes);
            case Constant.Tag.MethodHandle:
                return new MethodHandleConstant(clazz, bytes);
            case Constant.Tag.MethodType:
                return new MethodTypeConstant(clazz, bytes);
            case Constant.Tag.Dynamic:
                return new DynamicConstant(clazz, bytes);
            case Constant.Tag.InvokeDynamic:
                return new InvokeDynamicConstant(clazz, bytes);
            case Constant.Tag.Module:
                return new ModuleConstant(clazz, bytes);
            case Constant.Tag.Package:
                return new PackageConstant(clazz, bytes);
        }
        throw new RuntimeException("unsupported tag " + tag);
    }
}
