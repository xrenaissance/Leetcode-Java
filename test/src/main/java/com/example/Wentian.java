package com.example;

/**
 * Created by liwentian on 2017/8/29.
 */

public class Wentian extends People {

    @Override
    public void eat() {
        System.out.println("Wentian eat");
    }

    @Override
    public void sleep() {
        System.out.println("Wentian sleep");
    }

    @Override
    void call() {
        System.out.println("Wentian call");
    }
}
