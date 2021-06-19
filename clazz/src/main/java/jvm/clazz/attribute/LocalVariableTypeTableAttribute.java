package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;
import jvm.clazz.Items;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.7.14">4.7.14. The LocalVariableTypeTable Attribute</a>
 **/
public class LocalVariableTypeTableAttribute extends Attribute {
    private final LocalVariableTypeTables localVariableTypeTables;

    protected LocalVariableTypeTableAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        int exceptionsCount = bytes.readShortAsInt();
        this.localVariableTypeTables = LocalVariableTypeTables.from(clazz, bytes, exceptionsCount);
    }

    public LocalVariableTypeTables getLocalVariableTypeTables() {
        return localVariableTypeTables;
    }

    public static class LocalVariableTypeTable {
        private final Clazz clazz;
        private final int startPC;
        private final int length;
        private final int nameIndex;
        private final int signatureIndex;
        private final int index;

        public LocalVariableTypeTable(final Clazz clazz, final Bytes bytes) {
            this.clazz = clazz;
            this.startPC = bytes.readShortAsInt();
            this.length = bytes.readShortAsInt();
            this.nameIndex = bytes.readShortAsInt();
            this.signatureIndex = bytes.readShortAsInt();
            this.index = bytes.readShortAsInt();
        }

        public Clazz getClazz() {
            return clazz;
        }

        public int getStartPC() {
            return startPC;
        }

        public int getLength() {
            return length;
        }

        public int getNameIndex() {
            return nameIndex;
        }

        public int getSignatureIndex() {
            return signatureIndex;
        }

        public int getIndex() {
            return index;
        }
    }

    public static class LocalVariableTypeTables extends Items<LocalVariableTypeTable> {
        public LocalVariableTypeTables(Clazz clazz, int count, LocalVariableTypeTable[] items) {
            super(clazz, count, items);
        }

        public static LocalVariableTypeTables from(final Clazz clazz, final Bytes bytes, int count) {
            final LocalVariableTypeTable[] items = new LocalVariableTypeTable[count];
            for (int i = 0; i < count; i++) {
                items[i] = new LocalVariableTypeTable(clazz, bytes);
            }
            return new LocalVariableTypeTables(clazz, count, items);
        }
    }

}
