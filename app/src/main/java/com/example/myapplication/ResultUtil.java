package com.example.myapplication;

import java.math.BigDecimal;

/**
 * @ describe
 * @ author lzl
 * @ time 2023/4/14 5:00 PM
 */
class ResultUtil {
    private static BigDecimal result;

    public static void saveResult(String amount, String time) {
        BigDecimal bigAmount = new BigDecimal(amount);
        BigDecimal bigTime = new BigDecimal(time);
        result = bigAmount.multiply(bigTime);

    }

    public static BigDecimal getResult() {
        return result;
    }
    public static String toString(BigDecimal bigDecimal){
       BigDecimal bd=bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.toString();
    }
}
