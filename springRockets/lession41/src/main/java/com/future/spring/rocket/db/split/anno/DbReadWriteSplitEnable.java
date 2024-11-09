package com.future.spring.rocket.db.split.anno;

import com.future.spring.rocket.db.split.interceptor.DbTypeConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DbTypeConfiguration.class)
public @interface DbReadWriteSplitEnable {
}
