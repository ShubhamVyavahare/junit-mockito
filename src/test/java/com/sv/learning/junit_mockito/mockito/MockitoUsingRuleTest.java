package com.sv.learning.junit_mockito.mockito;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

public class MockitoUsingRuleTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    TodoService todoService;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void usingMockito() {
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");

        Mockito.when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Ranga");
        Assertions.assertEquals(2, todos.size());
    }

    @Test
    public void usingMockito_UsingBDD() {
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");

        //given
        BDDMockito.given(todoService.retrieveTodos("Ranga")).willReturn(allTodos);

        //when
        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Ranga");

        //then
        MatcherAssert.assertThat(todos.size(), Matchers.is(2));
    }

    @Test
    public void letsTestDeleteNow() {

        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");

        Mockito.when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");

        Mockito.verify(todoService).deleteTodo("Learn to Dance");

        Mockito.verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");

        Mockito.verify(todoService, Mockito.never()).deleteTodo("Learn Spring");

        Mockito.verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
        // atLeastOnce, atLeast

    }

    @Test
    public void captureArgument() {
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        Mockito.when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");
        Mockito.verify(todoService).deleteTodo(stringArgumentCaptor.capture());

        Assertions.assertEquals("Learn to Dance", stringArgumentCaptor.getValue());
    }

}
