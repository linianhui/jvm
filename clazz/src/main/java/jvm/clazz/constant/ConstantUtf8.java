package jvm.clazz.constant;

import jvm.clazz.Memory;

public class ConstantUtf8 extends Constant {
    private int length;
    private String value;

    public ConstantUtf8(Memory memory) {
        super(Tag.Utf8);
        this.length = memory.readShortAsInt();
        this.value = fromModifiedUtf8(memory.slice(this.length));
    }

    public String getValue() {
        return value;
    }

    /**
     * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.4.7">ModifiedUtf8</a>
     **/

    public static String fromModifiedUtf8(final Memory memory) {
        int length = memory.getLength();
        int endIndex = length - 1;
        int[] codePoints = new int[length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            int x = memory.readByteAsInt();
            // 0_1111111
            if ((x >>> 7) == 0b00000000) {
                codePoints[count] = x;
                count++;
                continue;
            }

            if (i + 1 > endIndex) {
                continue;
            }
            int y = memory.readByteAsInt();
            // 110_11111 && 10_111111
            if ((x >>> 5) == 0b00000_110 && (y >>> 6) == 0b000000_10) {
                codePoints[count] = (((x & 0b000_11111) << 6) + (y & 0b00_111111));
                count++;
                i += 1;
                continue;
            }

            if (i + 2 > endIndex) {
                continue;
            }
            int z = memory.readByteAsInt();
            // 1110_1111 && 10_111111 && 10_111111
            if ((x >>> 4) == 0b0000_1110 && (y >>> 6) == 0b000000_10 && (z >>> 6) == 0b000000_10) {
                codePoints[count] = (((x & 0b0000_1111) << 12) + ((y & 0b00_111111) << 6) + (z & 0b00_111111));
                count++;
                i += 2;
            }
        }
        return new String(codePoints, 0, count);
    }
}
