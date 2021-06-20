package jvm.clazz.constant;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;
import jvm.clazz.Items;

public class Constants extends Items<Constant> {

    public Constants(final Clazz clazz, int count, Constant[] items) {
        super(clazz, count, items);
    }

    public UTF8Constant getUTF8(int index) {
        return (UTF8Constant) get(index);
    }

    public String getUTF8String(int index) {
        return getUTF8(index).getValue();
    }

    public static Constants from(final Clazz clazz, final Bytes bytes) {
        int count = bytes.readShortAsInt();
        final Constant[] items = new Constant[count + 1];
        for (int i = 1; i < count; i++) {
            byte tag = bytes.readByte();
            items[i] = ConstantFactory.from(clazz, bytes, tag);
            if (Constant.Tag.as2Constant(tag)) {
                i++;
            }
        }
        return new Constants(clazz, count, items);
    }
}
