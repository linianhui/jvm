package jvm.clazz;

import java.util.HashSet;
import java.util.Set;

import jvm.clazz.util.BitUtil;

public interface FieldAccessFlag {
    int Public = 0x00_01;
    int Private = 0x00_02;
    int Protected = 0x00_04;
    int Static = 0x00_08;
    int Final = 0x00_10;
    int Volatile = 0x00_40;
    int Transient = 0x00_80;
    int Synthetic = 0x10_00;
    int Enum = 0x40_00;

    Set<Integer> ALL = new HashSet<>() {{
        this.add(Public);
        this.add(Private);
        this.add(Protected);
        this.add(Static);
        this.add(Final);
        this.add(Volatile);
        this.add(Transient);
        this.add(Synthetic);
        this.add(Enum);
    }};

    static Set<Integer> in(int value) {
        return BitUtil.in(ALL, value);
    }
}
