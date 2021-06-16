package jvm.clazz;

public interface ConstantTag {
    byte Utf8=1;
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
