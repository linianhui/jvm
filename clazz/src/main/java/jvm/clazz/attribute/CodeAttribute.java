package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;
import jvm.clazz.Items;

public class CodeAttribute extends Attribute {
    private final int maxStack;
    private final int maxLocals;
    private final int codeLength;
    private final Bytes code;
    private final ExceptionTables exceptionTables;
    private final Attributes attributes;

    protected CodeAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        this.maxStack = bytes.readShortAsInt();
        this.maxLocals = bytes.readShortAsInt();
        this.codeLength = bytes.readInt();
        this.code = bytes.slice(this.codeLength);
        int exceptionTableLength = bytes.readShortAsInt();
        this.exceptionTables = ExceptionTables.from(clazz, bytes, exceptionTableLength);
        this.attributes = Attributes.from(clazz, bytes);
    }

    public int getMaxStack() {
        return maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public int getCodeLength() {
        return codeLength;
    }

    public Bytes getCode() {
        return code;
    }

    public ExceptionTables getExceptionTables() {
        return exceptionTables;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public static class ExceptionTable {
        private final Clazz clazz;
        private final int startPC;
        private final int endPC;
        private final int handlerPC;
        private final int catchType;

        public ExceptionTable(final Clazz clazz, final Bytes bytes) {
            this.clazz = clazz;
            this.startPC = bytes.readShortAsInt();
            this.endPC = bytes.readShortAsInt();
            this.handlerPC = bytes.readShortAsInt();
            this.catchType = bytes.readShortAsInt();
        }

        public Clazz getClazz() {
            return clazz;
        }

        public int getStartPC() {
            return startPC;
        }

        public int getEndPC() {
            return endPC;
        }

        public int getHandlerPC() {
            return handlerPC;
        }

        public int getCatchType() {
            return catchType;
        }
    }

    public static class ExceptionTables extends Items<ExceptionTable> {
        public ExceptionTables(Clazz clazz, int count, ExceptionTable[] items) {
            super(clazz, count, items);
        }

        public static ExceptionTables from(final Clazz clazz, final Bytes bytes, int count) {
            final ExceptionTable[] items = new ExceptionTable[count];
            for (int i = 0; i < count; i++) {
                items[i] = new ExceptionTable(clazz, bytes);
            }
            return new ExceptionTables(clazz, count, items);
        }
    }
}
