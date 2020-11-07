package com.mrssz.devtools.utils;

import com.mrssz.devtools.constant.SwaggerConstant;

public class SwaggerConvertUtils {

    public static void main(String[] args) {
        String s = "    String name;";
        System.out.println(SwaggerConstant.TAB.concat(SwaggerConvertUtils.stringFormat(SwaggerConstant.SWAGGER,
                s.split(";")[0].split(" ")[s.split(" ").length-1],
                s.split(";")[0].split(" ")[s.split(" ").length-1])
        ));
    }

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
}
