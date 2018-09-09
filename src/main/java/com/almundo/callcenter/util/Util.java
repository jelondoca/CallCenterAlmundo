package com.almundo.callcenter.util;

import java.util.Random;

public class Util {

    private static final int MIN_TIME = 5;
    private static final int MAX_TIME = 10;

    Util() {
        throw new IllegalAccessError("Utility class");
    }

    public static int getRandomTimeCall() {
        Random randomTime = new Random();
        return randomTime.nextInt((MAX_TIME - MIN_TIME) + 1) + MIN_TIME;
    }
}
