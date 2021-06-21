package jvm.clazz;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    protected byte[] getBytes(final File file) {
        try {
            return new FileInputStream(file).readAllBytes();
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

    protected Bytes newBytes(int... arg) {
        return new Bytes(newByteArray(arg));
    }

    protected List<byte[]> findClassFileBytesList() {
        final List<byte[]> fileList = new ArrayList<>();
        try {
            final ClassLoader classLoader = AbstractTest.class.getClassLoader();
            final Iterator<URL> urls = classLoader.getResources("jvm")
                .asIterator();
            while (urls.hasNext()) {
                final URL url = urls.next();
                fileList.addAll(findClassFileBytesList(new File(url.getFile())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileList;
    }


    private List<byte[]> findClassFileBytesList(
        final File directory
    ) {
        final List<byte[]> fileList = new ArrayList<>();
        if (directory == null || !directory.isDirectory()) {
            return fileList;
        }

        final File[] fileArray = directory.listFiles();
        if (fileArray == null) {
            return fileList;
        }

        for (File file : fileArray) {
            if (file.isDirectory()) {
                fileList.addAll(findClassFileBytesList(file));
                continue;
            }
            if (file.getName().endsWith(".class")) {
                fileList.add(getBytes(file));
            }
        }
        return fileList;
    }
}
