package com.future.spring.rocket.model;

import com.future.spring.rocket.custom.ScanMark;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@ScanMark("将被扫描")
public class ComponentScanUserModel {

    private String name;
    private int age;
}
