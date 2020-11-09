package com.mrssz.devtools.service;

import com.mrssz.devtools.constant.SwaggerConstant;
import com.mrssz.devtools.utils.SwaggerConvertUtils;
import org.springframework.stereotype.Service;


@Service
public class SwaggerConvertService {
    public String addSwagger(String source, boolean camel, boolean data) {
        String[] sources = source.split("\n");
        StringBuilder result = new StringBuilder();
        String value = "";
        Integer spaceNum = 0;
        String spaceValue = "";
        for (String s : sources) {
            spaceValue = "";
            if (s.split(";").length ==2 && s.split(" ").length >= 6 && s.split("/.").length < 2) {
                switch (s.split(" ")[s.split(" ").length - 2]) {
                    case "Integer":
                        value = SwaggerConvertUtils.getRandomInteger().toString();
                        break;
                    case "String":
                        value = SwaggerConvertUtils.getRandomString();
                        break;
                    case "Date":
                        value = SwaggerConvertUtils.getRandomDate();
                        break;
                    default:
                        value = "example";
                }
                spaceNum = SwaggerConvertUtils.getSpaceNumber(s);
                for (int i = 0; i < spaceNum; i = i + 4) {
                    spaceValue += SwaggerConstant.TAB;
                }
                if (camel) {
                    char[] cs = s.split(";")[0].split(" ")[s.split(" ").length-1].toCharArray();
                    cs[0] -= 32;
                    result.append(spaceValue.concat(SwaggerConvertUtils.stringFormat(SwaggerConstant.JSON_PAR,
                            String.valueOf(cs))).concat("\n"));
                }
                result.append(spaceValue.concat(SwaggerConvertUtils.stringFormat(SwaggerConstant.SWAGGER,
                        s.split(";")[0].split(" ")[s.split(" ").length-1], value)).concat("\n"));
            }
            result.append(s);
        }

        return result.toString();
    }

}
