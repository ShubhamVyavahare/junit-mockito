package com.sv.learning.junit_mockito.mockito;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockitoVerifyCallTest {

    @Test
    public void mockListSize() {

        List listMock = Mockito.mock(List.class);

        listMock.size();

        Mockito.verify(listMock).size();
    }

    @Test
    public void mockListSize_GetMethodNeverCalled() {

        List listMock = Mockito.mock(List.class);

        listMock.size();

        Mockito.verify(listMock, Mockito.never()).getFirst();
    }

    @Test
    public void mockListSize_NumberOfTimes() {

        List listMock = Mockito.mock(List.class);

        listMock.size();
        listMock.size();

        Mockito.verify(listMock, Mockito.times(2)).size();
    }

    @Test
    public void mockListSize_AtLeastOnce() {

        List listMock = Mockito.mock(List.class);

        listMock.size();
        listMock.size();

        Mockito.verify(listMock, Mockito.atLeastOnce()).size();
    }

}
