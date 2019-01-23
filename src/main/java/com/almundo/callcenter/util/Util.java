package com.almundo.callcenter.util;

import java.util.Random;

public class Util {

    private static final int MIN_TIME = 5;
    private static final int MAX_TIME = 10;
    private static final Random randomTime = new Random();

    Util() {
        throw new IllegalAccessError("Utility class");
    }

    public static int getRandomTimeCall() {
        return randomTime.nextInt((MAX_TIME - MIN_TIME) + 1) + MIN_TIME;
    }
}
