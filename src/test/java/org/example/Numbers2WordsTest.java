package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Numbers2WordsTest {

    private final Numbers2Words numbers2Words = new Numbers2Words();

    @Test
    void should_return_NA_if_number_is_negative() {
        assertEquals("N/A", numbers2Words.convert(-123));
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
        // 12.345.675
        assertEquals("one hundred and twenty three million four hundred and fifty six thousand seven hundred and eighty nine", numbers2Words.convert(123456789));
    }


}
