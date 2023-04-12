package org.example;

public class Numbers2Words {

    public String convert(long number) {
        if (number < 0) {
            return "N/A";
        }
        return String.valueOf(number);
    }

}
