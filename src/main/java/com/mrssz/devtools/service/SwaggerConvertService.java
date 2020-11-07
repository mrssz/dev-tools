package com.mrssz.devtools.service;

import com.mrssz.devtools.constant.SwaggerConstant;
import com.mrssz.devtools.utils.SwaggerConvertUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SwaggerConvertService {
    public String addSwagger(String source) {
        String[] sources = source.split("\n");
        StringBuilder result = new StringBuilder();
        for (String s : sources) {
            if (s.split(";").length ==2 && s.split(" ").length >= 6 && s.split("/.").length < 2) {
                System.out.println(s);
                result.append(SwaggerConstant.TAB.concat(SwaggerConvertUtils.stringFormat(SwaggerConstant.SWAGGER,
                        s.split(";")[0].split(" ")[s.split(" ").length-1],
                        s.split(";")[0].split(" ")[s.split(" ").length-1])).concat("\n"));
                result.append(s);
            } else {
                result.append(s);
            }
        }

        return result.toString();
    }

}
