package com.future.spring.rocket.value.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoRefreshService {

    @Autowired
    private AutoRefreshModel autoRefreshModel;

    public AutoRefreshModel getAutoRefreshModel() {
        return autoRefreshModel;
    }

    @Override
    public String toString() {
        return String.format("autoRefreshModel:%s", autoRefreshModel);
    }
}
