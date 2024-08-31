package com.sv.learning.junit_mockito.mockito;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HamcrestMatchersTest {

    @Test
    public void testHamcrestMatchers() {
        List<Integer> scores = Arrays.asList(99, 100, 105, 103);

        //scores has 4 items
        MatcherAssert.assertThat(scores, Matchers.hasSize(4));

        //scores containing 99 and 100 elements
        MatcherAssert.assertThat(scores, Matchers.hasItems(99, 100));

        //every item > 90
        MatcherAssert.assertThat(scores, Matchers.everyItem(Matchers.greaterThan(90)));

        //every item < 200
        MatcherAssert.assertThat(scores, Matchers.everyItem(Matchers.lessThan(200)));

        MatcherAssert.assertThat("", Matchers.isEmptyString());
        MatcherAssert.assertThat(null, Matchers.isEmptyOrNullString());

        //arrays
        Integer[] marks = {1, 2, 3, 4};
        MatcherAssert.assertThat(marks, Matchers.arrayWithSize(4));
        MatcherAssert.assertThat(marks, Matchers.arrayContaining(1, 2, 3, 4));
        MatcherAssert.assertThat(marks, Matchers.arrayContainingInAnyOrder(4, 2, 1, 3));
    }

}
