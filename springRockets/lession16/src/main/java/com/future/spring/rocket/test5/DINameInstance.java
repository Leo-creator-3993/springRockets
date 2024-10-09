package com.future.spring.rocket.test5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DINameInstance {

    @Autowired
    private IDINameService dINameService1;

    @Autowired
    private List<IDINameService> idiNameServiceList;

    @Autowired
    private Map<String, IDINameService> idiNameServiceMap;

    @Override
    public String toString() {
        return String.format("diNameService:%s, idiNameServiceList:%s, idiNameServiceMap:%s", dINameService1, idiNameServiceList, idiNameServiceMap);
    }
}
