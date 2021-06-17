package jvm.clazz.constant;

import jvm.clazz.Clazz;
import jvm.clazz.Items;

public class Constants extends Items<Constant> {

    public Constants(final Clazz clazz, int count, Constant[] items) {
        super(clazz, count, items);
    }

    public UTF8Constant getUTF8(int index){
        return (UTF8Constant)get(index);
    }

    public String getUTF8String(int index){
        return getUTF8(index).getValue();
    }
}
