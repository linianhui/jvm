package jvm.clazz;

import java.util.Set;

import jvm.clazz.attribute.Attributes;
import jvm.clazz.constant.Constants;
import jvm.clazz.util.BitUtil;

public class Clazz {
    private final int magic;
    private final int minorVersion;
    private final int majorVersion;
    private final Constants constants;
    private final Set<AccessFlag> accessFlags;
    private final ClassIndex thisClass;
    private final ClassIndex superClass;
    private final Interfaces interfaces;
    private final Fields fields;
    private final Methods methods;
    private final Attributes attributes;

    public Clazz(final Bytes bytes) {
        this.magic = bytes.readInt();
        this.minorVersion = bytes.readShortAsInt();
        this.majorVersion = bytes.readShortAsInt();
        this.constants = Constants.from(this, bytes);
        this.accessFlags = AccessFlag.from(bytes.readShortAsInt());
        this.thisClass = ClassIndex.form(this, bytes.readShortAsInt());
        this.superClass = ClassIndex.form(this, bytes.readShortAsInt());
        this.interfaces = Interfaces.from(this, bytes);
        this.fields = Fields.from(this, bytes);
        this.methods = Methods.from(this, bytes);
        this.attributes = Attributes.from(this, bytes);
    }

    public int getMagic() {
        return magic;
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public Constants getConstants() {
        return constants;
    }

    public Set<AccessFlag> getAccessFlags() {
        return accessFlags;
    }

    public ClassIndex getThisClass() {
        return thisClass;
    }

    public ClassIndex getSuperClass() {
        return superClass;
    }

    public Interfaces getInterfaces() {
        return interfaces;
    }

    public Fields getFields() {
        return fields;
    }

    public Methods getMethods() {
        return methods;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public enum AccessFlag implements Bit {
        Public(0x00_01),
        Final(0x00_10),
        Super(0x00_20),
        Interface(0x02_00),
        Abstract(0x04_00),
        Synthetic(0x10_00),
        Annotation(0x20_00),
        Enum(0x40_00),
        Module(0x80_00);

        private final int raw;

        AccessFlag(int raw) {
            this.raw = raw;
        }

        public static Set<AccessFlag> from(int value) {
            return BitUtil.from(AccessFlag.class, value);
        }

        @Override
        public int raw() {
            return raw;
        }
    }
}
