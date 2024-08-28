package com.sv.learning.junit_mockito.junit;

public class AdditionService {

    public String addNumbers(String num1, String num2) {
        return String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2));
    }

}
