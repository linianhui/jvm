package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Items;
import jvm.clazz.Memory;

public class Constants extends Items<Constant> {

    public Constants(final Clazz clazz, int count, Constant[] items) {
        super(clazz, count, items);
    }

    public static Constants from(final Clazz clazz, final Memory memory, int count) {
        final Constant[] items = new Constant[count + 1];
        for (int i = 1; i < count; i++) {
            byte tag = memory.readByte();
            items[i] = Constant.from(clazz, memory, tag);
            if (Constant.Tag.as2Constant(tag)) {
                i++;
            }
        }
        return new Constants(clazz, count, items);
    }

    public UTF8Constant getUTF8(int index){
        return (UTF8Constant)get(index);
    }

    public String getUTF8String(int index){
        return getUTF8(index).getValue();
    }
}
