package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;

public class ElementValue {
    private final Clazz clazz;
    private final byte tag;
    private int constValueIndex;
    private int classInfoIndex;
    private EnumConstValue enumConstValue;
    private Annotation annotation;
    private ElementValues elementValues;

    protected ElementValue(final Clazz clazz, final Bytes bytes) {
        this.clazz = clazz;
        this.tag = bytes.readByte();
        if (Tag.isConst(this.tag)) {
            this.constValueIndex = bytes.readShortAsInt();
        } else if (Tag.isClass(this.tag)) {
            this.classInfoIndex = bytes.readShortAsInt();
        } else if (Tag.isEnum(this.tag)) {
            this.enumConstValue = new EnumConstValue(clazz, bytes);
        } else if (Tag.isAnnotation(this.tag)) {
            this.annotation = new Annotation(clazz, bytes);
        } else if (Tag.isArray(this.tag)) {
            this.elementValues = ElementValues.from(clazz, bytes);
        }
    }

    public static ElementValue from(final Clazz clazz, final Bytes bytes) {
        return new ElementValue(clazz, bytes);
    }

    public Clazz getClazz() {
        return clazz;
    }

    public int getConstValueIndex() {
        return constValueIndex;
    }

    public int getClassInfoIndex() {
        return classInfoIndex;
    }

    public EnumConstValue getEnumConstValue() {
        return enumConstValue;
    }

    public Annotation getAnnotation() {
        return annotation;
    }

    public ElementValues getElementValues() {
        return elementValues;
    }

    public interface Tag {
        byte BYTE = (byte) 'B';
        byte CHAR = (byte) 'C';
        byte DOUBLE = (byte) 'D';
        byte FLOAT = (byte) 'F';
        byte INT = (byte) 'I';
        byte LONG = (byte) 'J';
        byte SHORT = (byte) 'S';
        byte BOOLEAN = (byte) 'z';
        byte STRING = (byte) 's';
        byte ENUM = (byte) 'e';
        byte CLASS = (byte) 'c';
        byte ANNOTATION = (byte) '@';
        byte ARRAY = (byte) '[';

        static boolean isConst(byte value) {
            return value==BYTE
                    || value==CHAR
                    || value==DOUBLE
                    || value==FLOAT
                    || value==INT
                    || value==LONG
                    || value==SHORT
                    || value==BOOLEAN
                    || value==STRING;
        }

        static boolean isEnum(byte value) {
            return value==ENUM;
        }

        static boolean isClass(byte value) {
            return value==CLASS;
        }

        static boolean isAnnotation(byte value) {
            return value==ANNOTATION;
        }

        static boolean isArray(byte value) {
            return value==ARRAY;
        }
    }

    public static class EnumConstValue {
        private final Clazz clazz;
        private final int typeNameIndex;
        private final int constNameIndex;

        public EnumConstValue(final Clazz clazz, final Bytes bytes) {
            this.clazz = clazz;
            this.typeNameIndex = bytes.readShortAsInt();
            this.constNameIndex = bytes.readShortAsInt();
        }

        public Clazz getClazz() {
            return clazz;
        }

        public int getTypeNameIndex() {
            return typeNameIndex;
        }

        public int getConstNameIndex() {
            return constNameIndex;
        }
    }
}
