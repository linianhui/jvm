package jvm.clazz;

import java.util.HashSet;
import java.util.Set;

import jvm.clazz.util.BitUtil;

public interface ClassAccessFlag {
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
