// package com.api.config;

// import java.io.FileInputStream;
// import java.io.IOException;
// import java.io.InputStream;
// import java.util.Properties;

// public class configReader {
//     private static Properties properties = new Properties();

//     static {
//         try (InputStream input = new FileInputStream("config.properties")) {
//             properties.load(input);
//         } catch (IOException ex) {
//             ex.printStackTrace();
//         }
//     }
//     public static String getProperty(String key) {
//         return properties.getProperty(key);
//     }
// }


package com.api.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configReader {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = configReader.class.getClassLoader().getResourceAsStream("properties/config.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                System.err.println("config.properties not found in classpath!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
