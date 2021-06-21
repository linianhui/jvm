package jvm.clazz;

public class ClassIndex {
    private final Clazz clazz;
    private final int index;

    private ClassIndex(final Clazz clazz, int index) {
        this.clazz = clazz;
        this.index = index;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return clazz.getConstants().getClassString(index);
    }

    public static ClassIndex form(final Clazz clazz, int index) {
        return new ClassIndex(clazz, index);
    }
}
