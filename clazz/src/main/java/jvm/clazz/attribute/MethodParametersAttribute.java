package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;
import jvm.clazz.Items;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.7.24">MethodParameters Attribute</a>
 **/
public class MethodParametersAttribute extends Attribute {
    private final MethodParameters methodParameters;

    protected MethodParametersAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        this.methodParameters = MethodParameters.from(clazz, bytes);
    }

    public MethodParameters getMethodParameters() {
        return methodParameters;
    }

    public static class MethodParameter {
        private final Clazz clazz;
        private final int nameIndex;
        private final int accessFlags;

        public MethodParameter(final Clazz clazz, final Bytes bytes) {
            this.clazz = clazz;
            this.nameIndex = bytes.readShortAsInt();
            this.accessFlags = bytes.readShortAsInt();
        }

        public Clazz getClazz() {
            return clazz;
        }

        public int getNameIndex() {
            return nameIndex;
        }

        public int getAccessFlags() {
            return accessFlags;
        }
    }

    public static class MethodParameters extends Items<MethodParameter> {
        public MethodParameters(Clazz clazz, int count, MethodParameter[] items) {
            super(clazz, count, items);
        }

        public static MethodParameters from(final Clazz clazz, final Bytes bytes) {
            int count = bytes.readShortAsInt();
            final MethodParameter[] items = new MethodParameter[count];
            for (int i = 0; i < count; i++) {
                items[i] = new MethodParameter(clazz, bytes);
            }
            return new MethodParameters(clazz, count, items);
        }
    }

}
