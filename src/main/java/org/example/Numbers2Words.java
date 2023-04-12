package org.example;

public class Numbers2Words {
    private final String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private final String[] tens = {"", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private final String[] thousands = {"", "thousand", "million", "billion", "trillion"};


    public String convert(long number) {
        if (number <= 0) {
            return "N/A";
        }

        if (number > 999999999) {
            return "Number to large";
        }

        StringBuilder words = new StringBuilder();
        int i = 0;
        while (number > 0) {
            if (number % 1000 != 0) {
                String groupWords = convertHundreds((int) (number % 1000));
                if (i > 0) {
                    groupWords += " " + thousands[i];
                }
                if (words.length() > 0) {
                    groupWords += " ";
                }
                words.insert(0, groupWords);
            }
            number /= 1000;
            i++;
        }
        return words.toString().trim();
    }

    private String convertHundreds(int number) {
        String current;
        if (number % 100 < 20) {
            current = ones[number % 100];
            number /= 100;
        } else {
            current = ones[number % 10];
            number /= 10;

            current = tens[number % 10] + " " + current;
            number /= 10;
        }
        if (number == 0) {
            return current;
        }
        if (current.isEmpty()) {
            return ones[number] + " hundred";
        }
        return ones[number] + " hundred and " + current;
    }

}
