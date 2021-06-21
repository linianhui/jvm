package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;
import jvm.clazz.Indexes;
import jvm.clazz.Items;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.7.23">BootstrapMethods Attribute</a>
 **/
public class BootstrapMethodsAttribute extends Attribute {
    private final BootstrapMethods bootstrapMethods;

    protected BootstrapMethodsAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        this.bootstrapMethods = BootstrapMethods.from(clazz, bytes);
    }

    public BootstrapMethods getBootstrapMethods() {
        return bootstrapMethods;
    }

    public static class BootstrapMethod {
        private final Clazz clazz;
        private final int ref;
        private final Indexes arguments;

        public BootstrapMethod(final Clazz clazz, final Bytes bytes) {
            this.clazz = clazz;
            this.ref = bytes.readShortAsInt();
            this.arguments = Indexes.from(clazz,bytes);
        }

        public Clazz getClazz() {
            return clazz;
        }

        public int getRef() {
            return ref;
        }

        public Indexes getArguments() {
            return arguments;
        }
    }

    public static class BootstrapMethods extends Items<BootstrapMethod> {
        public BootstrapMethods(Clazz clazz, int count, BootstrapMethod[] items) {
            super(clazz, count, items);
        }

        public static BootstrapMethods from(final Clazz clazz, final Bytes bytes) {
            int count = bytes.readShortAsInt();
            final BootstrapMethod[] items = new BootstrapMethod[count];
            for (int i = 0; i < count; i++) {
                items[i] = new BootstrapMethod(clazz, bytes);
            }
            return new BootstrapMethods(clazz, count, items);
        }
    }

}
