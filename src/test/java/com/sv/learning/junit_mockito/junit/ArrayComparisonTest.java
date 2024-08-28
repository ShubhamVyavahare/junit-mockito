package com.sv.learning.junit_mockito.junit;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArrayComparisonTest {

    @Test
    public void testArrayComparison() {

        int[] numbers = {12, 4, 3, 1};
        int[] expected = {1, 3, 4, 12};

        Arrays.sort(numbers);

        Assert.assertArrayEquals(expected, numbers);
    }

}
