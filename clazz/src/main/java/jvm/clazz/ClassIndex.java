package jvm.clazz;

public class ClassIndex extends ClazzAccessor {
    private final int index;

    private ClassIndex(final Clazz clazz, int index) {
        super(clazz);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return getConstants().getClassString(index);
    }

    public static ClassIndex form(final Clazz clazz, int index) {
        return new ClassIndex(clazz, index);
    }
}
