package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Numbers2WordsTest {

    private final Numbers2Words numbers2Words = new Numbers2Words();

    @Test
    void should_convert_long_to_string() {
        String convert = numbers2Words.convert(33232);

        assertEquals("33232", convert);

    }

}
