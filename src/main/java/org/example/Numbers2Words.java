package org.example;

public class Numbers2Words {

    private final long MAX_VALUE = 999999999;

    public String convert(long number) {
        if (number < 0) {
            return "N/A";
        }

        if(number > MAX_VALUE) {
            return "Number to large";
        }

        return String.valueOf(number);
    }

}
