package com.sv.learning.junit_mockito.mockito;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.List;

public class MockitoBddListTest {

    @Test
    public void mockListSize() {

        //given
        List listMock = Mockito.mock(List.class);
        BDDMockito.given(listMock.size()).willReturn(2);

        //when
        int size = listMock.size();

        //then
        MatcherAssert.assertThat(size, Matchers.is(2));
    }

    @Test
    public void mockListSize_NeverCalled() {

        //given
        List listMock = Mockito.mock(List.class);
        BDDMockito.given(listMock.size()).willReturn(2);

        //when
        listMock.size();

        //then
        BDDMockito.then(listMock).should(Mockito.never()).getFirst();
    }

}
