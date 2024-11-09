package com.future.spring.rocket.test.module;

import com.future.spring.rocket.test.JunitModel;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class JunitModelTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("==> Before Class...");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("==> After Class...");
    }

    @Before
    public void beforeTest() {
        System.out.println("==> Before Test...");
    }

    @After
    public void afterTest() {
        System.out.println("==> After Test...");
    }

    @Test
    public void test0() {
        System.out.println("hi");
    }


    @Test
    public void testMax() {
        System.out.println("==> 【testMax】...");
        int max = JunitModel.max(1,2,3,4,5,6,99);
        assertEquals(99, max);
        System.out.println("==> End 【testMax】...");
    }

    @Test
    public void testMin() {
        System.out.println("==> testMin...");
        int min = JunitModel.min(1,2,3,4,5,6,99, -1, -99, -100, -3873);
        assertEquals(-3873, min);
        System.out.println("==> End 【testMin】...");
    }
}
