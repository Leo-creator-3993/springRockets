package com.future.spring.rocket.value.test3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;

public class SimulateUpdateUtil {

    private SimulateUpdateUtil() {

    }

    public static void refreshDbProperties(AbstractApplicationContext context) {
        Map<String, Object> dbProperties = DbAutoSimulateUtil.getDbProperties();
        MapPropertySource mapPropertySource = new MapPropertySource("mail", dbProperties);
        context.getEnvironment().getPropertySources().addFirst(mapPropertySource);
        MyRefreshScope.getINSTANCE().clean();
    }
}
