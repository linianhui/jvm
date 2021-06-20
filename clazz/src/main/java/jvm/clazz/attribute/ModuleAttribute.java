package jvm.clazz.attribute;

import jvm.clazz.Bytes;
import jvm.clazz.Clazz;
import jvm.clazz.Indexes;
import jvm.clazz.Items;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.7.25">Module Attribute</a>
 **/
public class ModuleAttribute extends Attribute {
    private final int moduleNameIndex;
    private final int flags;
    private final int versionIndex;
    private final Requires requires;
    private final Exports exports;
    private final Opens opens;
    private final Uses uses;
    private final Provides provides;

    protected ModuleAttribute(final Clazz clazz, int nameIndex, String name, Bytes bytes) {
        super(clazz, nameIndex, name, bytes, false);
        this.moduleNameIndex = bytes.readShortAsInt();
        this.flags = bytes.readShortAsInt();
        this.versionIndex = bytes.readShortAsInt();
        this.requires = Requires.from(clazz, bytes);
        this.exports = Exports.from(clazz, bytes);
        this.opens = Opens.from(clazz, bytes);
        this.uses = Uses.from(clazz, bytes);
        this.provides = Provides.from(clazz, bytes);
    }

    public Requires getRequires() {
        return requires;
    }

    public int getModuleNameIndex() {
        return moduleNameIndex;
    }

    public int getFlags() {
        return flags;
    }

    public int getVersionIndex() {
        return versionIndex;
    }

    public Exports getExports() {
        return exports;
    }

    public Opens getOpens() {
        return opens;
    }

    public Uses getUses() {
        return uses;
    }

    public Provides getProvides() {
        return provides;
    }

    public static class Require {
        private final Clazz clazz;
        private final int index;
        private final int flags;
        private final int versionIndex;

        public Require(final Clazz clazz, final Bytes bytes) {
            this.clazz = clazz;
            this.index = bytes.readShortAsInt();
            this.flags = bytes.readShortAsInt();
            this.versionIndex = bytes.readShortAsInt();
        }

        public Clazz getClazz() {
            return clazz;
        }

        public int getIndex() {
            return index;
        }

        public int getFlags() {
            return flags;
        }

        public int getVersionIndex() {
            return versionIndex;
        }

    }

    public static class Requires extends Items<Require> {
        public Requires(Clazz clazz, int count, Require[] items) {
            super(clazz, count, items);
        }

        public static Requires from(final Clazz clazz, final Bytes bytes) {
            int count = bytes.readShortAsInt();
            final Require[] items = new Require[count];
            for (int i = 0; i < count; i++) {
                items[i] = new Require(clazz, bytes);
            }
            return new Requires(clazz, count, items);
        }
    }

    public static class Export {
        private final Clazz clazz;
        private final int index;
        private final int flags;
        private final Indexes indexes;

        public Export(final Clazz clazz, final Bytes bytes) {
            this.clazz = clazz;
            this.index = bytes.readShortAsInt();
            this.flags = bytes.readShortAsInt();
            this.indexes = Indexes.from(clazz,bytes);
        }

        public Clazz getClazz() {
            return clazz;
        }

        public int getIndex() {
            return index;
        }

        public int getFlags() {
            return flags;
        }

        public Indexes getIndexes() {
            return indexes;
        }
    }

    public static class Exports extends Items<Export> {
        public Exports(Clazz clazz, int count, Export[] items) {
            super(clazz, count, items);
        }

        public static Exports from(final Clazz clazz, final Bytes bytes) {
            int count = bytes.readShortAsInt();
            final Export[] items = new Export[count];
            for (int i = 0; i < count; i++) {
                items[i] = new Export(clazz, bytes);
            }
            return new Exports(clazz, count, items);
        }
    }

    public static class Open {
        private final Clazz clazz;
        private final int index;
        private final int flags;
        private final Indexes indexes;

        public Open(final Clazz clazz, final Bytes bytes) {
            this.clazz = clazz;
            this.index = bytes.readShortAsInt();
            this.flags = bytes.readShortAsInt();
            this.indexes = Indexes.from(clazz,bytes);
        }

        public Clazz getClazz() {
            return clazz;
        }

        public int getIndex() {
            return index;
        }

        public int getFlags() {
            return flags;
        }

        public Indexes getIndexes() {
            return indexes;
        }

    }

    public static class Opens extends Items<Open> {
        public Opens(Clazz clazz, int count, Open[] items) {
            super(clazz, count, items);
        }

        public static Opens from(final Clazz clazz, final Bytes bytes) {
            int count = bytes.readShortAsInt();
            final Open[] items = new Open[count];
            for (int i = 0; i < count; i++) {
                items[i] = new Open(clazz, bytes);
            }
            return new Opens(clazz, count, items);
        }
    }

    public static class Uses extends Items<Integer> {
        public Uses(final Clazz clazz, int count, Integer[] items) {
            super(clazz, count, items);
        }

        public static Uses from(final Clazz clazz, final Bytes bytes) {
            int count = bytes.readShortAsInt();
            final Integer[] items = new Integer[count];
            for (int i = 0; i < count; i++) {
                items[i] = bytes.readShortAsInt();
            }
            return new Uses(clazz, count, items);
        }
    }

    public static class Provide {
        private final Clazz clazz;
        private final int index;
        private final Indexes indexes;

        public Provide(final Clazz clazz, final Bytes bytes) {
            this.clazz = clazz;
            this.index = bytes.readShortAsInt();
            this.indexes = Indexes.from(clazz,bytes);
        }

        public Clazz getClazz() {
            return clazz;
        }

        public int getIndex() {
            return index;
        }

        public Indexes getIndexes() {
            return indexes;
        }
    }

    public static class Provides extends Items<Provide> {
        public Provides(Clazz clazz, int count, Provide[] items) {
            super(clazz, count, items);
        }

        public static Provides from(final Clazz clazz, final Bytes bytes) {
            int count = bytes.readShortAsInt();
            final Provide[] items = new Provide[count];
            for (int i = 0; i < count; i++) {
                items[i] = new Provide(clazz, bytes);
            }
            return new Provides(clazz, count, items);
        }
    }

}
