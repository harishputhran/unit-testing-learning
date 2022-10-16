package com.learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class IntegerSumGeneratorTest {

    private IntegerSumGenerator classToTest = new IntegerSumGenerator();

    // Test Method Naming - Underscore based with all lower case
    @Test
    void should_add_two_valid_integers() {
        assertEquals(5, classToTest.addNumbers(3, 2));
    }

    // Test Method Naming - CamelCase
    @Test
    void shouldAddTwoValidIntegers() {
        assertEquals(5, classToTest.addNumbers(3, 2));
    }

    // HAPPY PATH SCENARIOS
    @DisplayName("Addition of two Integers - Happy Path scenarios")
    @ParameterizedTest( name = "{index} => {0}]")
    @CsvSource({
            "'return_sum_of_5_for_numbers_3_and_2','3','2','5'",
            "'return_sum_of_5_for_numbers_6_and_-1','6','-1','5'"})
    void addition_of_numbers_scenarios(String testName, Integer firstNumber, Integer secondNumber, Integer expectedSum) {
        assertEquals(expectedSum, classToTest.addNumbers(firstNumber, secondNumber));
    }


    // EXCEPTION SCENARIOS
    @DisplayName("Addition of two Integers - Exception scenarios")
    @ParameterizedTest( name = "{index} => {0}]")
    @CsvSource({
            "'should_throw_exception_when_first_number_is_invalid',,'2'",
            "'should_throw_exception_when_first_number_is_invalid','2',",})
    void exception_scenarios_for_addition_of_numbers(String testName, Integer firstNumber, Integer secondNumber) {
        assertThrows(IllegalArgumentException.class, () -> classToTest.addNumbers(firstNumber, secondNumber));
    }


    @Test
    void do_not_write_such_test_methods() {
        assertEquals(5, classToTest.addNumbers(3, 2));
        assertThrows(IllegalArgumentException.class, () -> classToTest.addNumbers(null, 2));
    }

    @Test
    void should_throw_exception_for_invalid_numbers() {
        assertThrows(IllegalArgumentException.class, () -> classToTest.addNumbers(null, 2));
    }
}