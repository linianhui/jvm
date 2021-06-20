package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;
import jvm.clazz.Items;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.7.26">ModulePackages Attribute</a>
 **/
public class ModulePackagesAttribute extends Attribute {
    private final ModulePackages modulePackages;

    protected ModulePackagesAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        this.modulePackages = ModulePackages.from(clazz, bytes);
    }

    public ModulePackages getModulePackages() {
        return modulePackages;
    }

    public static class ModulePackages extends Items<Integer> {
        public ModulePackages(final Clazz clazz, int count, Integer[] items) {
            super(clazz, count, items);
        }

        public static ModulePackages from(final Clazz clazz, final Bytes bytes) {
            int count = bytes.readShortAsInt();
            final Integer[] items = new Integer[count];
            for (int i = 0; i < count; i++) {
                items[i] = bytes.readShortAsInt();
            }
            return new ModulePackages(clazz, count, items);
        }
    }
}
