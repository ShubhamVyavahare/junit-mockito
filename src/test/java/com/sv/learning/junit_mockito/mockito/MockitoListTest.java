package com.sv.learning.junit_mockito.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.List;

public class MockitoListTest {

    @Test
    public void mockListSize() {
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.size()).thenReturn(2);
        Assert.assertEquals(2, listMock.size());
    }

    @Test
    public void mockListSize_ReturnMultipleValues() {
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.size()).thenReturn(2).thenReturn(3);
        Assert.assertEquals(2, listMock.size());
        Assert.assertEquals(3, listMock.size());
    }

    @Test
    public void mockListGet() {
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.get(0)).thenReturn("shubham");
        Assert.assertEquals("shubham", listMock.get(0));
        Assert.assertEquals(null, listMock.get(1)); // this is called nice mocks -- if mocking is not mentioned then default values getting returned
    }

    @Test
    public void mockListAruMatchers() {
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.get(ArgumentMatchers.anyInt())).thenReturn("shubham");
        Assert.assertEquals("shubham", listMock.get(0));
        Assert.assertEquals("shubham", listMock.get(20));
    }

    @Test(expected = RuntimeException.class)
    public void mockListException() {
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.get(ArgumentMatchers.anyInt())).thenThrow(RuntimeException.class);
        listMock.get(0);
    }

}
