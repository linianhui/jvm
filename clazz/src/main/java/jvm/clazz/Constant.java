package jvm.clazz;

public class Constant {
    private byte tag;

    public Constant(byte tag) {
        this.tag = tag;
    }

    public static Constant[] from(final Memory memory, int count) {
        final Constant[] constants = new Constant[count + 1];
        for (int i = 1; i <= count; i++) {
            constants[i]= from(memory);
        }
        return constants;
    }

    private static Constant from(final Memory memory) {
        byte tag = memory.readByte();
        switch (tag){
            case ConstantTag.Utf8:
                return new ConstantUtf8(tag, memory);
            case ConstantTag.Class:
                return new ConstantClass(tag, memory);
        }
        return null;
    }

    public byte getTag() {
        return tag;
    }
}
