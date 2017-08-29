package com.example;

/**
 * Created by liwentian on 2017/8/29.
 */

public class PigManager {

    private static Pig sPig = new Yulu();

    public static Pig getPig() {
        return sPig;
    }
}
