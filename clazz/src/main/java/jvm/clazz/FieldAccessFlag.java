package jvm.clazz;

import java.util.HashSet;
import java.util.Set;

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

    static Set<Integer> from(int value) {
        final Set<Integer> all = new HashSet<>();
        if ((value & 0x00_01) != 0) {
            all.add(FieldAccessFlag.Public);
        }

        if ((value & 0x00_02) != 0) {
            all.add(FieldAccessFlag.Private);
        }

        if ((value & 0x00_04) != 0) {
            all.add(FieldAccessFlag.Protected);
        }

        if ((value & 0x00_08) != 0) {
            all.add(FieldAccessFlag.Static);
        }

        if ((value & 0x00_10) != 0) {
            all.add(FieldAccessFlag.Final);
        }

        if ((value & 0x00_40) != 0) {
            all.add(FieldAccessFlag.Volatile);
        }

        if ((value & 0x00_80) != 0) {
            all.add(FieldAccessFlag.Transient);
        }

        if ((value & 0x10_00) != 0) {
            all.add(FieldAccessFlag.Synthetic);
        }

        if ((value & 0x40_00) != 0) {
            all.add(FieldAccessFlag.Enum);
        }
        return all;
    }
}
