package com.future.spring.rocket.test7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class QualifierInstance {

    @Autowired
    @Qualifier("iQService1")
    private List<IQualifierService> iQualifierServiceList;

    @Autowired
    @Qualifier("iQService2")
    private Map<String, IQualifierService> iQualifierServiceMap;

    @Autowired
    private Set<IQualifierService> qualifierServiceSet;

    @Override
    public String toString() {
        return String.format("iQualifierServiceList:%s, iQualifierServiceMap:%s, qualifierServiceSet:%s", iQualifierServiceList, iQualifierServiceMap, qualifierServiceSet);
    }
}
