package jvm.clazz;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public abstract class AbstractTest {
    protected byte[] getResourceBytes(final String filePath) {
        try {
            final String fileUrl = filePath.startsWith("/") ? filePath : "/" + filePath;
            return Test.class
                .getResourceAsStream(fileUrl)
                .readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected byte[] newByteArray(int... arg) {
        byte[] bytes = new byte[arg.length];
        for (int i = 0; i < arg.length; i++) {
            bytes[i] = (byte) arg[i];
        }
        return bytes;
    }

    protected Bytes newBytes(int... arg){
        return new Bytes(newByteArray(arg));
    }
}
