package com.el.jichu.io;

import java.io.File;
import java.nio.file.FileSystems;

public class DeliteFiles {
    public static void main(String[] args) {
        File file = new File("/tmp/list");
        deleteFiles(file);
    }

    private static void deleteFiles(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFiles(f);
                } else {
                    f.delete();
                }
            }
        }
        file.delete();

    }
}
