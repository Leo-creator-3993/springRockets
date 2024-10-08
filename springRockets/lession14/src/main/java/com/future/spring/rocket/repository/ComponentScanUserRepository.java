package com.future.spring.rocket.repository;

import com.future.spring.rocket.custom.ScanMark;
import org.springframework.stereotype.Repository;

@Repository
@ScanMark(value = "被标注则被扫描")
public class ComponentScanUserRepository {
}
