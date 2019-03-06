package com.ozzot.echoserver.utils;

public class Checker {

    public static void isNotNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Data can't be null");
        }
    }
}
