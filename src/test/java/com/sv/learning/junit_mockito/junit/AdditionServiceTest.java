package com.sv.learning.junit_mockito.junit;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class AdditionServiceTest {

    AdditionService additionService = new AdditionService();

    @BeforeClass
    public static void beforeClassSetup() {
        System.out.println("Before Class !!!");
    }

    @AfterClass
    public static void afterClassSetup() {
        System.out.println("After Class !!!");
    }

    @Before
    public void setup() {
        System.out.println("Before Each Test !!!");
    }

    @After
    public void tearDown() {
        System.out.println("After Each Test !!!");
    }

    @Test
    public void testAddNumbers_PositiveScenario() {
        System.out.println("testAddNumbers_PositiveScenario");
        assertEquals("3", additionService.addNumbers("1", "2"));
    }

    @Test(expected = NumberFormatException.class)
    public void testAddNumbers_NegativeScenario() {
        System.out.println("testAddNumbers_NegativeScenario");
        assertEquals("3", additionService.addNumbers("1", null));
    }

}
