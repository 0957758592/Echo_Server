package com.ozzot.echoserver.utils;

public class Checker {

    public static void isNotNull(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Data can't be null");
        }
    }

    public static void isDbPropertiesNotNull(String dbProperties) {

        if (dbProperties == null) {
            throw new IllegalArgumentException(dbProperties + " is undefined");
        }
    }

}
