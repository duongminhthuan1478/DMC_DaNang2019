package com.example.android.dmc_danang2019.common;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatCommon {
    public static String reNumberFloat(float num) {
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        long longNumber = (long) num;
        String str1 = en.format(longNumber);
        return str1;
    }

    public static String reNumberInt(int num) {
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        long longNumber = (long) num;
        String str1 = en.format(longNumber);
        return str1;
    }
    public static String reNumberDouble(double num) {
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        long longNumber = (long) num;
        String str1 = en.format(longNumber);
        return str1;
    }
}
