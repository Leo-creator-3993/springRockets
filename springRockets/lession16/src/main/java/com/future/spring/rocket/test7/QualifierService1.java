package com.future.spring.rocket.test7;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("iQService1")
public class QualifierService1 implements IQualifierService{
}
