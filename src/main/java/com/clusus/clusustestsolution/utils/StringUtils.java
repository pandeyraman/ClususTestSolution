package com.clusus.clusustestsolution.utils;

public class StringUtils {

    public static boolean isNull( String str){
        return str == null || str.trim().length() == 0 || str.equals("");
    }

    public static boolean isNotEmpty(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static String clean(String str) {
        return str == null ? "" : str.trim();
    }

    public static boolean equalsIgnoreCase(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);
    }
}
