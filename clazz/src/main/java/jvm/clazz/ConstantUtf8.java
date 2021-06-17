package jvm.clazz;

public class ConstantUtf8 extends Constant {
    private int length;
    private String value;

    public ConstantUtf8(Memory memory) {
        super(Tag.Utf8);
        this.length = memory.readShortAsInt();
        this.value = ModifiedUtf8.toString(memory.slice(this.length));
    }

    public String getValue() {
        return value;
    }
}
