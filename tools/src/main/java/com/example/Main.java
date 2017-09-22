package com.example;

import java.io.IOException;

public class Main {

    private static final String TITLE = "";

    public static void main(String[] args) {
        try {
            CheckRepeatTex.check(TITLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
