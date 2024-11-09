package com.future.spring.rocket.test;

import com.future.spring.rocket.test.module.JunitModelTest;
import com.future.spring.rocket.test.module.MainConfigTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({JunitModelTest.class, MainConfigTest.class})
public class AllTest {
}
