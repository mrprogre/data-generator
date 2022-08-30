package com.avandy.dataset.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Util {

    public static double round(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    // Маппинг строк в цифры
    public static int getRowsCount(String row) {
        int rowsCount;
        switch (row) {
            case "100k":
                rowsCount = 100_000;
                break;
            case "500k":
                rowsCount = 500_000;
                break;
            default:
                rowsCount = 10_000;
        }
        return rowsCount;
    }

}