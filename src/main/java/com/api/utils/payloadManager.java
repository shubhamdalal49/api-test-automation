package com.api.utils;

public class payloadManager {
    public static String getUserPayload(String name, String job) {
        return "{ \"name\": \"" + name + "\", \"job\": \"" + job + "\" }";
    }
}
