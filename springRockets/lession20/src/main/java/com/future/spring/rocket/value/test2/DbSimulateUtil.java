package com.future.spring.rocket.value.test2;

import java.util.HashMap;
import java.util.Map;

public class DbSimulateUtil {

    private DbSimulateUtil() {

    }

    public static Map<String, Object> getDbProperties() {
        Map<String, Object> dbPropertiesMap = new HashMap<>();
        dbPropertiesMap.put("mail.host", "smtp.xxx.com");
        dbPropertiesMap.put("mail.userName", "creator3993");
        dbPropertiesMap.put("mail.passwd", "xxx010");
        return dbPropertiesMap;
    }
}
