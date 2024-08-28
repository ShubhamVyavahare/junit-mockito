package com.sv.learning.junit_mockito.junit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PerformanceTest {

    @Test(timeout = 100)
    public void testSort_Performance() {

        List<Integer> integerList = new ArrayList<>();

        for (int i = 1; i < 1000000; i++) {
            integerList.add(i);
        }

        List<Integer> sortedList = integerList.stream().sorted().toList();
    }

}
