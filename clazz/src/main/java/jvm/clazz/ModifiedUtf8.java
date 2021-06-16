package jvm.clazz;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.4.7">ModifiedUtf8</a>
 **/
public class ModifiedUtf8 {

    public static String toString(final Memory memory) {
        int endIndex = memory.getLength() - 1;
        char[] chars = new char[endIndex + 1];
        int count = 0;
        for (int i = 0; i <= endIndex; i++) {
            int x = memory.readByteAsInt();
            // 0_1111111
            if ((x >>> 7)==0b00000000) {
                chars[i] = (char) x;
                count++;
                continue;
            }

            if (i + 1 > endIndex) {
                continue;
            }
            int y = memory.readByteAsInt();
            // 110_11111 && 10_111111
            if ((x >>> 5)==0b00000_110 && (y >>> 6)==0b000000_10) {
                chars[i] = (char) (((x & 0b000_11111) << 6) + (y & 0b00_111111));
                count++;
                continue;
            }

            if (i + 2 > endIndex) {
                continue;
            }
            int z = memory.readByteAsInt();
            // 1110_1111 && 10_111111 && 10_111111
            if ((x >>> 4)==0b0000_1110 && (y >>> 6)==0b000000_10 && (z >>> 6)==0b000000_10) {
                chars[i] = (char) (((x & 0b0000_1111) << 12) + ((y & 0b00_111111) << 6) + (z & 0b00_111111));
                count++;
                continue;
            }
        }
        return new String(chars, 0, count);
    }
}

