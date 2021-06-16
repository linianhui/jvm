import java.lang.RuntimeException;

public class class_file_test implements Comparable<class_file_test> {
    public static final boolean BOOLEAN_VALUE = true;
    public static final byte BYTE_VALUE = 32;
    public static final char CHAR_VALUE = 'L';
    public static final String STRING_VALUE = "LNH中文😀";
    public static final short SHORT_VALUE = 12345;
    public static final int INT_VALUE = 123456789;
    public static final long LONG_VALUE = 12345678901L;
    public static final float FLOAT_VALUE = 3.14F;
    public static final double DOUBLE_VALUE = 123.456D;

    public static void main(String[] args) throws RuntimeException {
        System.out.println("hello rust jvm(div) for java!");
        System.out.println(BOOLEAN_VALUE);
        System.out.println(BYTE_VALUE);
        System.out.println(CHAR_VALUE);
        System.out.println(STRING_VALUE);
        System.out.println(SHORT_VALUE);
        System.out.println(INT_VALUE);
        System.out.println(LONG_VALUE);
        System.out.println(FLOAT_VALUE);
        System.out.println(DOUBLE_VALUE);
    }

    @Override
    public int compareTo(class_file_test o) {
      return 0;
    }
}