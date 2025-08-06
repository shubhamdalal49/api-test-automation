package com.api.utils;

import java.nio.file.*;
import java.io.IOException;

public class JsonUtil {
    public static String readJsonFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/resources/data" + filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
