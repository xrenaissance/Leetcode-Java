package com.example;

/**
 * Created by liwentian on 2017/8/29.
 */

public class Yulu extends People {

    @Override
    public void eat() {
        System.out.println("Yulu eat");
    }

    @Override
    public void sleep() {
        System.out.println("Yulu sleep");
    }

    @Override
    void call() {
        System.out.println("Yulu call");
    }
}
