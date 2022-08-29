package com.avandy.dataset.util;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class PropertiesUtils {
    public static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    // загрузка настроек
    private static void loadProperties() {
        try (InputStream is = PropertiesUtils.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // возврат значения по ключу
    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
