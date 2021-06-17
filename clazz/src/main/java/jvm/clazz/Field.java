package jvm.clazz;

import java.util.Set;

import jvm.clazz.attribute.AttributeFactory;
import jvm.clazz.attribute.Attributes;
import jvm.clazz.util.BitUtil;

public class Field {
    private final Clazz clazz;
    private final Set<AccessFlag> accessFlags;
    private final int nameIndex;
    private final int descriptorIndex;
    private final Attributes attributes;

    public Field(final Clazz clazz, final Bytes bytes) {
        this.clazz = clazz;
        this.accessFlags = AccessFlag.from(bytes.readShortAsInt());
        this.nameIndex = bytes.readShortAsInt();
        this.descriptorIndex = bytes.readShortAsInt();
        int attributesCount = bytes.readShortAsInt();
        this.attributes = AttributeFactory.from(clazz, bytes, attributesCount);
    }

    public Set<AccessFlag> getAccessFlags() {
        return accessFlags;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public enum AccessFlag implements Bit {
        Public(0x00_01),
        Private(0x00_02),
        Protected(0x00_04),
        Static(0x00_08),
        Final(0x00_10),
        Volatile(0x00_40),
        Transient(0x00_80),
        Synthetic(0x10_00),
        Enum(0x40_00);

        private final int raw;

        AccessFlag(int raw) {
            this.raw = raw;
        }

        static Set<AccessFlag> from(int value) {
            return BitUtil.from(AccessFlag.class, value);
        }

        @Override
        public int raw() {
            return raw;
        }
    }
}
