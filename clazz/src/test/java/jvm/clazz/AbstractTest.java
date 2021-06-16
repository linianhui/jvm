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
}
