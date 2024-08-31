package com.sv.learning.junit_mockito.mockito;

import java.util.List;

public interface TodoService {

    public List<String> retrieveTodos(String user);

    void deleteTodo(String todo);

}
