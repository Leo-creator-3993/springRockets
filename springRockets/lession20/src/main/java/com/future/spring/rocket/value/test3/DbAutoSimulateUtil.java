package com.future.spring.rocket.value.test3;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DbAutoSimulateUtil {

    private DbAutoSimulateUtil() {
    }

    public static Map<String, Object> getDbProperties() {
        Map<String, Object> dbPropertiesMap = new HashMap<>();
        dbPropertiesMap.put("custom.testField", UUID.randomUUID().toString());
        return dbPropertiesMap;
    }
}
