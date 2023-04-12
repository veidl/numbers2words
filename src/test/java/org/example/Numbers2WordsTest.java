package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Numbers2WordsTest {

    private final Numbers2Words numbers2Words = new Numbers2Words();

    @ParameterizedTest
    @ValueSource(longs = {0, -1, -111, -0})
    void should_return_NA_if_number_is_negative(long number) {
        assertEquals("N/A", numbers2Words.convert(number));
    }

    @ParameterizedTest
    @ValueSource(longs = {9999999990L, 1000000000, 999999999})
    void should_return_number_to_large_if_max_number_is_exceeded(long number) {
        assertEquals("Number to large", numbers2Words.convert(number));
    }

    @Test
    void should_convert_ones() {
        assertEquals("one", numbers2Words.convert(1));
    }

    @Test
    void should_convert_tens() {
        assertEquals("ten", numbers2Words.convert(10));
    }

    @Test
    void should_convert_nine_hundred() {
        assertEquals("nine hundred", numbers2Words.convert(900));

    }

    @Test
    void should_convert_hundreds() {
        assertEquals("seven hundred and fourty five", numbers2Words.convert(745));
    }

    @Test
    void should_convert_thousands() {
        assertEquals("one thousand fifty", numbers2Words.convert(1050));
    }

    @Test
    void should_convert_ten_thousands() {
        assertEquals("twelve thousand five hundred and thirty eight", numbers2Words.convert(12538));
    }

    @Test
    void should_convert_hundred_thousands() {
        assertEquals("one hundred and twenty five thousand three hundred and ninety eight", numbers2Words.convert(125398));
    }

    @Test
    void should_convert_one_million() {
        assertEquals("one million", numbers2Words.convert(1000000));
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
