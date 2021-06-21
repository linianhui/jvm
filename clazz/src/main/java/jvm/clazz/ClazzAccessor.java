package jvm.clazz;

import jvm.clazz.constant.Constants;

public class ClazzAccessor {
    private final Clazz clazz;

    public ClazzAccessor(final Clazz clazz) {
        this.clazz = clazz;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public Constants getConstants() {
        return clazz.getConstants();
    }
}
