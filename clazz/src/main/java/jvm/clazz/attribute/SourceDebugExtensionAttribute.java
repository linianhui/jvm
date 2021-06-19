package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;
import jvm.clazz.Items;

public class SourceDebugExtensionAttribute extends Attribute {
    private final SourceDebugExtensions sourceDebugExtensions;

    protected SourceDebugExtensionAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        this.sourceDebugExtensions = SourceDebugExtensions.from(clazz, bytes, super.getLength());
    }

    public SourceDebugExtensions getSourceDebugExtensions() {
        return sourceDebugExtensions;
    }

    public static class SourceDebugExtensions extends Items<Integer> {
        public SourceDebugExtensions(final Clazz clazz, int count, Integer[] items) {
            super(clazz, count, items);
        }

        public static SourceDebugExtensions from(final Clazz clazz, final Bytes bytes, int count) {
            final Integer[] items = new Integer[count];
            for (int i = 0; i < count; i++) {
                items[i] = bytes.readByteAsInt();
            }
            return new SourceDebugExtensions(clazz, count, items);
        }
    }
}
