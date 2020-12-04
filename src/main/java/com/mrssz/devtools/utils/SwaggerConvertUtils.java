package com.mrssz.devtools.utils;

import com.mrssz.devtools.constant.SwaggerConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public static String getRandomDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd:HH:mm:ss");
        return localDateTime.format(dateTimeFormatter);
    }

    public static Integer getSpaceNumber(String string) {
        String temp = (string + "A").trim();
        return string.length() - (temp.substring(0, (temp.length() - 1)).length());
  }

    public static String StringAddPrefix(String raw, String prefix) {
        if (prefix.isEmpty()) {
            return raw;
        }
        String result = "";
        for (int i = 0; i < raw.length(); i++) {
            if (raw.charAt(i) != ' ') {
                result = raw.substring(0, i).concat(prefix).concat(" ").concat(raw.substring(i));
                break;
            }
        }
        return result;
    }

}
