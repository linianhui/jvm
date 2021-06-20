package jvm.clazz.attribute;

import java.util.Set;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;
import jvm.clazz.Items;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.7.6">4.7.6. The InnerClasses Attribute</a>
 **/
public class InnerClassesAttribute extends Attribute {
    private final InnerClasses innerClasses;

    protected InnerClassesAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        this.innerClasses = InnerClasses.from(clazz, bytes);
    }

    public InnerClasses getInnerClasses() {
        return innerClasses;
    }

    public static class InnerClass {
        private final Clazz clazz;
        private final int innerClassInfoIndex;
        private final int outerClassInfoIndex;
        private final int innerNameIndex;
        private final Set<Clazz.AccessFlag> innerClassAccessFlags;

        public InnerClass(final Clazz clazz, final Bytes bytes) {
            this.clazz = clazz;
            this.innerClassInfoIndex = bytes.readShortAsInt();
            this.outerClassInfoIndex = bytes.readShortAsInt();
            this.innerNameIndex = bytes.readShortAsInt();
            this.innerClassAccessFlags = Clazz.AccessFlag.from(bytes.readShortAsInt());
        }

        public Clazz getClazz() {
            return clazz;
        }

        public int getInnerClassInfoIndex() {
            return innerClassInfoIndex;
        }

        public int getOuterClassInfoIndex() {
            return outerClassInfoIndex;
        }

        public int getInnerNameIndex() {
            return innerNameIndex;
        }

        public Set<Clazz.AccessFlag> getInnerClassAccessFlags() {
            return innerClassAccessFlags;
        }
    }

    public static class InnerClasses extends Items<InnerClass> {
        public InnerClasses(Clazz clazz, int count, InnerClass[] items) {
            super(clazz, count, items);
        }

        public static InnerClasses from(final Clazz clazz, final Bytes bytes) {
            int count = bytes.readShortAsInt();
            final InnerClass[] items = new InnerClass[count];
            for (int i = 0; i < count; i++) {
                items[i] = new InnerClass(clazz, bytes);
            }
            return new InnerClasses(clazz, count, items);
        }
    }

}
