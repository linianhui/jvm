package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;
import jvm.clazz.Items;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.7.12">4.7.12. The LineNumberTable Attribute</a>
 * **/
public class LineNumberTableAttribute extends Attribute {
    private final LineNumberTables lineNumberTables;

    protected LineNumberTableAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        int exceptionsCount = bytes.readShortAsInt();
        this.lineNumberTables = LineNumberTables.from(clazz, bytes, exceptionsCount);
    }

    public LineNumberTables getLineNumberTables() {
        return lineNumberTables;
    }

    public static class LineNumberTable {
        private final Clazz clazz;
        private final int startPC;
        private final int lineNumber;

        public LineNumberTable(final Clazz clazz, final Bytes bytes) {
            this.clazz = clazz;
            this.startPC = bytes.readShortAsInt();
            this.lineNumber = bytes.readShortAsInt();
        }

        public Clazz getClazz() {
            return clazz;
        }

        public int getStartPC() {
            return startPC;
        }

        public int getLineNumber() {
            return lineNumber;
        }
    }

    public static class LineNumberTables extends Items<LineNumberTable> {
        public LineNumberTables(Clazz clazz, int count, LineNumberTable[] items) {
            super(clazz, count, items);
        }

        public static LineNumberTables from(final Clazz clazz, final Bytes bytes, int count) {
            final LineNumberTable[] items = new LineNumberTable[count];
            for (int i = 0; i < count; i++) {
                items[i] = new LineNumberTable(clazz, bytes);
            }
            return new LineNumberTables(clazz, count, items);
        }
    }

}
