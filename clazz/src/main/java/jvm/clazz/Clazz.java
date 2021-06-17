package jvm.clazz;

import java.util.HashSet;
import java.util.Set;

import jvm.clazz.attribute.Attributes;
import jvm.clazz.constant.Constants;
import jvm.clazz.util.BitUtil;

public class Clazz {
    private final int magic;
    private final int minorVersion;
    private final int majorVersion;
    private final Constants constants;
    private final Set<Integer> accessFlags;
    private final int thisClass;
    private final int superClass;
    private final int interfacesCount;
    private final int[] interfaces;
    private final Fields fields;
    private final Methods methods;
    private final Attributes attributes;

    public Clazz(final Memory memory) {
        this.magic = memory.readInt();
        this.minorVersion = memory.readShortAsInt();
        this.majorVersion = memory.readShortAsInt();
        int constantsCount = memory.readShortAsInt();
        this.constants = Constants.from(memory, constantsCount);
        this.accessFlags = AccessFlag.in(memory.readShortAsInt());
        this.thisClass = memory.readShortAsInt();
        this.superClass = memory.readShortAsInt();
        this.interfacesCount = memory.readShortAsInt();
        this.interfaces = memory.readShortAsInts(this.interfacesCount);
        int fieldsCount = memory.readShortAsInt();
        this.fields = Fields.from(this, memory, fieldsCount);
        int methodsCount = memory.readShortAsInt();
        this.methods = Methods.from(this, memory, methodsCount);
        int attributesCount = memory.readShortAsInt();
        this.attributes = Attributes.from(this, memory, attributesCount);
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

    public Set<Integer> getAccessFlags() {
        return accessFlags;
    }

    public int getThisClass() {
        return thisClass;
    }

    public int getSuperClass() {
        return superClass;
    }

    public int getInterfacesCount() {
        return interfacesCount;
    }

    public int[] getInterfaces() {
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

    public interface AccessFlag {
        int Public = 0x00_01;
        int Final = 0x00_10;
        int Super = 0x00_20;
        int Interface = 0x02_00;
        int Abstract = 0x04_00;
        int Synthetic = 0x10_00;
        int Annotation = 0x20_00;
        int Enum = 0x40_00;
        int Module = 0x80_00;

        Set<Integer> ALL = new HashSet<>() {{
            this.add(Public);
            this.add(Final);
            this.add(Super);
            this.add(Interface);
            this.add(Abstract);
            this.add(Synthetic);
            this.add(Annotation);
            this.add(Enum);
            this.add(Module);
        }};

        static Set<Integer> in(int value) {
            return BitUtil.in(ALL, value);
        }
    }
}
