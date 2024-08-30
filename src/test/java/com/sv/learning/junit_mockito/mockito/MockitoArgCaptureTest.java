package com.sv.learning.junit_mockito.mockito;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.List;

public class MockitoArgCaptureTest {

    @Test
    public void mockListGet_ArgumentCaptor_BDD() {

        ArgumentCaptor<Integer> integerArgumentCaptor = ArgumentCaptor.forClass(Integer.class);

        List listMock = Mockito.mock(List.class);

        listMock.get(4);

        BDDMockito.then(listMock).should().get(integerArgumentCaptor.capture());

        MatcherAssert.assertThat(integerArgumentCaptor.getValue(), Matchers.is(4));
    }

}
