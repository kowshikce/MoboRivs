package com.example.moborivs.constants;

public class Constant {
    private static volatile String token;

    public static String getToken() {
        return String.format("Bearer %s", token);
    }

    public static void setToken(String token) {
        Constant.token = token;
    }
}
