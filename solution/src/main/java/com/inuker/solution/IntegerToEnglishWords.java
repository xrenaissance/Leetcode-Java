package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/19.
 */

/**
 * TestCase
 * 0
 * 1001
 * 1000000
 */
public class IntegerToEnglishWords {

    private final String[] LESS_20 = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private final String[] LESS_100 = {
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private final String[] THOUSANDS = {
            "", "Thousand", "Million", "Billion"
    };

    // 这种写法耗时4ms，简洁效率还高
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String words = "";
        for (int i = 0; num > 0; i++, num /= 1000) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            }
        }
        return words.trim();
    }

    /**
     * 求1000以内的
     */
    private String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return LESS_20[num] + " ";
        else if (num < 100)
            return LESS_100[num / 10] + " " + helper(num % 10);
        else
            return LESS_20[num / 100] + " Hundred " + helper(num % 100);
    }
}
