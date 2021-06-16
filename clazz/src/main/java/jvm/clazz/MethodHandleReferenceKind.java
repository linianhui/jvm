package jvm.clazz;

public interface MethodHandleReferenceKind {
    byte GetField = 1;
    byte GetStatic = 2;
    byte PutField = 3;
    byte PutStatic = 4;
    byte InvokeVirtual = 5;
    byte InvokeStatic = 6;
    byte InvokeSpecial = 7;
    byte NewInvokeSpecial = 8;
    byte InvokeInterface = 9;
}
