package com.kochiu.javaPasser.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by IntelliJ IDEA.
 * User: gaochao
 * Date: 2016/6/21.
 * Time: 10:42.
 */
public class FinanceMath {

    public static final double DOUBLE_PRECISION = 0.000001;

    public static int doubleCompare(double a, double b) {
        return compare(a, b, DOUBLE_PRECISION);
    }

    public static double doubleMin(double a, double b) {
        return doubleCompare(a, b) <= 0 ? a : b;
    }

    public static double doubleMax(double a, double b) {
        return doubleCompare(a, b) >= 0 ? a : b;
    }

    public static final double MONEY_PRECISION = 0.005;

    public static int moneyCompare(double lhs, double rhs) {
        return compare(lhs, rhs, MONEY_PRECISION);
    }

    public static double round(double value, int places,
                               RoundingMode roundingMode) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, roundingMode);
        return bd.doubleValue();
    }

    private static int compare(double lhs, double rhs, double precision) {
        double diff = lhs - rhs;
        if (diff >= precision) {
            return 1;
        } else if (diff <= -precision) {
            return -1;
        } else {
            return 0;
        }
    }

}