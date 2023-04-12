package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Numbers2WordsTest {

    private final Numbers2Words numbers2Words = new Numbers2Words();


    @ParameterizedTest
    @ValueSource(longs = {0,-1,-111,-0})
    void should_return_NA_if_number_is_negative(long number) {
        assertEquals("N/A", numbers2Words.convert(number));
    }

    @Test
    void should_return_number_to_large_if_max_number_is_exceeded() {
        assertEquals("Number to large", numbers2Words.convert(9999999990L));
    }

    @Test
    void should_convert_number_to_words() {
        assertEquals("seven hundred and fourty five", numbers2Words.convert(745));
    }

    @Test
    void should_convert_millions_to_words() {
        assertEquals("one hundred and twenty three million four hundred and fifty six thousand seven hundred and eighty nine", numbers2Words.convert(123456789));
    }

    @Test
    void should_convert_max_number_to_words() {
        assertEquals("nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety eight", numbers2Words.convert(999999998));
    }
}
