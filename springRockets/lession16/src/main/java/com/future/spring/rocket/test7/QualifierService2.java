package com.future.spring.rocket.test7;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("iQService2")
public class QualifierService2 implements IQualifierService{
}
