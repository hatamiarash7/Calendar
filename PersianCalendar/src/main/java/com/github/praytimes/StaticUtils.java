package com.github.praytimes;

import org.jetbrains.annotations.Contract;

class StaticUtils {
    @Contract(pure = true)
    static double dtr(double d) {
        return (d * Math.PI) / 180d;
    }

    @Contract(pure = true)
    static double rtd(double r) {
        return (r * 180d) / Math.PI;
    }

    @Contract("_ -> !null")
    static MinuteOrAngleDouble deg(int value) {
        return deg((double) value);
    }

    @Contract("_ -> !null")
    public static MinuteOrAngleDouble min(int value) {
        return min((double) value);
    }

    @Contract("_ -> !null")
    static MinuteOrAngleDouble deg(double value) {
        return new MinuteOrAngleDouble(value, false);
    }

    @Contract("_ -> !null")
    private static MinuteOrAngleDouble min(double value) {
        return new MinuteOrAngleDouble(value, true);
    }

    @Contract(pure = true)
    static double fixHour(double a) {
        return fix(a, 24);
    }

    @Contract(pure = true)
    private static double fix(double a, double b) {
        double result = a % b;
        if (result < 0)
            result = b + result;
        return result;
    }
}