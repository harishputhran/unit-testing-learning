package com.learning;

import java.util.Objects;

public class IntegerSumGenerator {

    public Integer addNumbers(Integer firstNumber, Integer secondNumber) {
        if (Objects.isNull(firstNumber)
        || Objects.isNull(secondNumber)) {
            throw new IllegalArgumentException("Input numbers are not valid");
        }

        return Integer.sum(firstNumber, secondNumber);
    }
}
