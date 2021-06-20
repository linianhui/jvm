package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;
import jvm.clazz.Items;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.7.13">4.7.13. The LocalVariableTable Attribute</a>
 **/
public class LocalVariableTableAttribute extends Attribute {
    private final LocalVariableTables localVariableTables;

    protected LocalVariableTableAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        this.localVariableTables = LocalVariableTables.from(clazz, bytes);
    }

    public LocalVariableTables getLocalVariableTables() {
        return localVariableTables;
    }

    public static class LocalVariableTable {
        private final Clazz clazz;
        private final int startPC;
        private final int length;
        private final int nameIndex;
        private final int descriptorIndex;
        private final int index;

        public LocalVariableTable(final Clazz clazz, final Bytes bytes) {
            this.clazz = clazz;
            this.startPC = bytes.readShortAsInt();
            this.length = bytes.readShortAsInt();
            this.nameIndex = bytes.readShortAsInt();
            this.descriptorIndex = bytes.readShortAsInt();
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

        public int getDescriptorIndex() {
            return descriptorIndex;
        }

        public int getIndex() {
            return index;
        }
    }

    public static class LocalVariableTables extends Items<LocalVariableTable> {
        public LocalVariableTables(Clazz clazz, int count, LocalVariableTable[] items) {
            super(clazz, count, items);
        }

        public static LocalVariableTables from(final Clazz clazz, final Bytes bytes) {
            int count = bytes.readShortAsInt();
            final LocalVariableTable[] items = new LocalVariableTable[count];
            for (int i = 0; i < count; i++) {
                items[i] = new LocalVariableTable(clazz, bytes);
            }
            return new LocalVariableTables(clazz, count, items);
        }
    }

}
