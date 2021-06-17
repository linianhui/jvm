package jvm.clazz.constant;

import jvm.clazz.Memory;

public class Constants {
    private final int count;
    private final Constant[] items;

    public Constants(int count, Constant[] items) {
        this.count = count;
        this.items = items;
    }

    public static Constants from(final Memory memory, int count) {
        final Constant[] items = new Constant[count + 1];
        for (int i = 1; i < count; i++) {
            byte tag = memory.readByte();
            items[i] = Constant.from(memory, tag);
            if (Constant.Tag.as2Constant(tag)) {
                i++;
            }
        }
        return new Constants(count, items);
    }

    public Constant[] getItems() {
        return items;
    }

    public int getCount() {
        return count;
    }
}
