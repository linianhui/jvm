package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;

public class Attribute {

    private final Clazz clazz;
    private final int nameIndex;
    private final String name;
    private final int length;

    protected Attribute(
        final Clazz clazz,
        final int nameIndex,
        final String name,
        final Bytes bytes,
        final boolean slice
    ) {
        this.clazz = clazz;
        this.nameIndex = nameIndex;
        this.name = name;
        this.length = bytes.readInt();
        if (slice) {
            bytes.slice(this.length);
        }
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public Clazz getClazz() {
        return clazz;
    }

    /**
     * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.7-310">Table 4.7-B. Predefined class file attributes (by class file format)</a>
     * **/
    public interface Name {
        String ConstantValue = "ConstantValue";
        String Code = "Code";
        String Exceptions = "Exceptions";
        String SourceFile = "SourceFile";
        String LineNumberTable = "LineNumberTable";
        String LocalVariableTable = "LocalVariableTable";
        String InnerClasses = "InnerClasses";
        String Synthetic = "Synthetic";
        String Deprecated = "Deprecated";
        String EnclosingMethod = "EnclosingMethod";
        String Signature = "Signature";
        String SourceDebugExtension = "SourceDebugExtension";
        String LocalVariableTypeTable = "LocalVariableTypeTable";
        String RuntimeVisibleAnnotations = "RuntimeVisibleAnnotations";
    }
}
