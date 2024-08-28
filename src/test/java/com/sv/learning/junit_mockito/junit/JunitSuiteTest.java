package com.sv.learning.junit_mockito.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AdditionServiceTest.class, ArrayComparisonTest.class})
public class JunitSuiteTest {
}
