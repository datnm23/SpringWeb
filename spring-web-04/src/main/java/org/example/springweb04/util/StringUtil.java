package org.example.springweb04.util;

public class StringUtil {

    public static boolean isNullOrEmpty(String str) {
        return DataUtil.isNullOrEmpty(str) || str.trim().isEmpty();
    }

}
