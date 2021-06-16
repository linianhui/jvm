package jvm.clazz;

public abstract class Constant {
    private final byte tag;

    protected Constant(byte tag) {
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
                return new ConstantClass(memory);
            case ConstantTag.Dynamic:
                return new ConstantDynamic(memory);
        }
        return null;
    }

    public byte getTag() {
        return tag;
    }
}
