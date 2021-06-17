package jvm.clazz.constant;

import jvm.clazz.Memory;

public class MethodHandleConstant extends Constant {
    private final byte referenceKind;
    private final int referenceIndex;

    public MethodHandleConstant(final Memory memory) {
        super(Tag.MethodHandle);
        referenceKind = memory.readByte();
        referenceIndex = memory.readShortAsInt();
    }

    public byte getReferenceKind() {
        return referenceKind;
    }

    public int getReferenceIndex() {
        return referenceIndex;
    }

    public interface ReferenceKind {
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
}
