package jvm.clazz;

import java.util.HashSet;
import java.util.Set;

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

    static Set<Integer> from(int value) {
        final Set<Integer> all = new HashSet<>();
        if ((value & 0x00_01)!=0) {
            all.add(ClassAccessFlag.Public);
        }

        if ((value & 0x00_10)!=0) {
            all.add(ClassAccessFlag.Final);
        }

        if ((value & 0x00_20)!=0) {
            all.add(ClassAccessFlag.Super);
        }

        if ((value & 0x02_00)!=0) {
            all.add(ClassAccessFlag.Interface);
        }

        if ((value & 0x04_00)!=0) {
            all.add(ClassAccessFlag.Abstract);
        }

        if ((value & 0x10_00)!=0) {
            all.add(ClassAccessFlag.Synthetic);
        }

        if ((value & 0x20_00)!=0) {
            all.add(ClassAccessFlag.Annotation);
        }

        if ((value & 0x40_00)!=0) {
            all.add(ClassAccessFlag.Enum);
        }

        if ((value & 0x80_00)!=0) {
            all.add(ClassAccessFlag.Module);
        }

        return all;
    }
}
