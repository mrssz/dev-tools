package com.mrssz.devtools.service;

import com.mrssz.devtools.constant.SwaggerConstant;
import com.mrssz.devtools.utils.SwaggerConvertUtils;
import org.springframework.stereotype.Service;


@Service
public class SwaggerConvertService {
    public String addSwagger(String source) {
        String[] sources = source.split("\n");
        StringBuilder result = new StringBuilder();
        String value = "";
        for (String s : sources) {
            if (s.split(";").length ==2 && s.split(" ").length >= 6 && s.split("/.").length < 2) {
                switch (s.split(" ")[s.split(" ").length - 2]) {
                    case "Integer":
                        value = SwaggerConvertUtils.getRandomInteger().toString();
                        break;
                    case "String":
                        value = SwaggerConvertUtils.getRandomString();
                        break;
                    default:
                        value = "example";
                }
                result.append(SwaggerConstant.TAB.concat(SwaggerConvertUtils.stringFormat(SwaggerConstant.SWAGGER,
                        s.split(";")[0].split(" ")[s.split(" ").length-1], value)).concat("\n"));
            }
            result.append(s);
        }

        return result.toString();
    }

}
