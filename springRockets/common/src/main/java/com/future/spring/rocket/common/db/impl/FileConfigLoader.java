package com.future.spring.rocket.common.db.impl;

import com.future.spring.rocket.common.db.ConfigLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileConfigLoader implements ConfigLoader {
    private final Properties properties = new Properties();
    private final String propertiesPath;

    public FileConfigLoader(String propertiesPath) {
        this.propertiesPath = propertiesPath;
        init();
    }

    private void init() {
        try (InputStream input = FileConfigLoader.class.getClassLoader().getResourceAsStream(propertiesPath)) {
            if (input == null) {
                throw new IllegalArgumentException("Unable to find properties file: " + propertiesPath);
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load properties file: " + propertiesPath, ex);
        }
    }

    @Override
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
