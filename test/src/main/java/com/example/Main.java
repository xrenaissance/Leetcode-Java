package com.example;


import java.sql.Timestamp;
import java.util.Calendar;

public class Main {

    private static String fd(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || c == '-' || c == ':' || c == '.') {
                sb.append(c);
            } else {
                sb.append(' ');
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "2000-09-14T03:40:07.445Z";

        s = fd(s);

        System.out.println(s);

        Timestamp stamp = Timestamp.valueOf(s);
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(stamp.getTime());

        int max = c.getActualMaximum(Calendar.DAY_OF_YEAR);
        System.out.println(max);

        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH) + 1);
        System.out.println(c.get(Calendar.DATE));
        System.out.println(c.get(Calendar.DAY_OF_YEAR));
        System.out.println(c.get(Calendar.HOUR_OF_DAY));
        System.out.println(c.get(Calendar.MINUTE));
        System.out.println(c.get(Calendar.SECOND));
        System.out.println(c.get(Calendar.MILLISECOND));
    }
}

