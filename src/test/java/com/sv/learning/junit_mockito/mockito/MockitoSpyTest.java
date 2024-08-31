package com.sv.learning.junit_mockito.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class MockitoSpyTest {

    @Test
    public void spyTest() {

        List arrayListSpy = Mockito.spy(ArrayList.class);

        Assert.assertEquals(0, arrayListSpy.size());

        arrayListSpy.add("Dummy");

        Assert.assertEquals(1, arrayListSpy.size());

        arrayListSpy.remove("Dummy");

        Assert.assertEquals(0, arrayListSpy.size());

    }

    @Test
    public void spyTest_SizePartialMock() {

        List arrayListSpy = Mockito.spy(ArrayList.class);

        Mockito.when(arrayListSpy.size()).thenReturn(5);

        Assert.assertEquals(5, arrayListSpy.size());

    }

}
