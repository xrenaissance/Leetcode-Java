package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/19.
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

    // 耗时31ms，性能不怎么样，而且代码复杂，容易出错
    public String numberToWords(int num) {
        if (num == 0) {
            return "zero";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; num > 0; num /= 1000, i++) {
            StringBuilder sb2 = new StringBuilder();

            int n = num % 1000;

            if (n == 0) {
                continue;
            }

            int hundred = n / 100;
            if (hundred > 0) {
                sb2.append(String.format(" %s hundred", LESS_20[hundred]));
            }

            n %= 100;

            if (n >= 20) {
                sb2.append(String.format(" %s", LESS_100[n / 10]));
                if (n % 10 != 0) {
                    sb2.append(String.format(" %s", LESS_20[n % 10]));
                }

            } else if (n > 0) {
                sb2.append(String.format(" %s", LESS_20[n]));
            }

            sb.insert(0, String.format("%s %s", sb2.toString(), THOUSANDS[i]));
        }

        return sb.toString().trim();
    }

    // 这种写法耗时4ms，简洁效率还高
    public String numberToWords2(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0)
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            num /= 1000;
            i++;
        }

        return words.trim();
    }

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
