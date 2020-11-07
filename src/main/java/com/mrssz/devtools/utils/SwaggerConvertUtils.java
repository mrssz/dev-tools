package com.mrssz.devtools.utils;

import com.mrssz.devtools.constant.SwaggerConstant;

import java.util.Random;

public class SwaggerConvertUtils {
    static Random r = new Random();

    public static String stringFormat(String origin, String... args) {
        StringBuilder result = new StringBuilder(origin);
        String rep = "{}";
        for (String arg : args) {
            int start = result.indexOf(rep);
            int end = start + rep.length();
            result.replace(start, end, arg);
        }
        return result.toString();
    }

    public static Integer getRandomInteger() {
        return r.nextInt(10000);
    }

    public static String getRandomString() {
        StringBuilder sb = new StringBuilder();
        int length = r.nextInt(15);
        for(int i = 0; i < length; i++){
            int number=r.nextInt(62);
            sb.append(SwaggerConstant.STRING_TEMPLATE.charAt(number));
        }
        return sb.toString();
    }


//    public static void main(String[] args) {
//        System.out.println(getRandomInteger());
//        System.out.println(getRandomString());
//    }

}
