package com.mrssz.devtools.service;

import com.mrssz.devtools.constant.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BatchQueryService {
    public String generateController(String params, String resultType, String tableName) {
        String[] paramlines = params.split("\n");
        String dtoType = "";

        StringBuilder stringBuilder= new StringBuilder();
        // Init
        stringBuilder.append("<select id=\"mixQuery\" resultType=\"com.example.entity.").append(resultType).append("\">\n");
        stringBuilder.append(CommonConstant.TAB).append("SELECT * FROM ").append(tableName).append(" WHERE id > 0\n");

        for (String line : paramlines) {
            if (line.contains("class")) {
                dtoType = line.split(" ")[line.split(" ").length-2];
            } else if (line.contains(";")) {
                String[] elements = line.split(";")[0].split(" ");
                String element = elements[elements.length - 1];
                stringBuilder.append(CommonConstant.DOUBLE_TAB).append("<if test=\"queryDto.")
                        .append(element).append(" != null\">\n");
                if (line.contains("List")) {
                    // atchQuery
                    stringBuilder.append(CommonConstant.TRIBLE_TAB).append("AND ").append(element.split("List")[0]).append(" IN\n");
                    stringBuilder.append(CommonConstant.TRIBLE_TAB).append("<foreach collection=\"queryDto.").append(element).append("\" item=\"")
                            .append(element.split("List")[0]).append("\" open=\"(\" close=\")\" separator=\",\">\n");
                    stringBuilder.append(CommonConstant.FOUR_TAB).append("#{").append(element).append("}\n");
                    stringBuilder.append(CommonConstant.TRIBLE_TAB).append("</foreach>\n");
                } else {
                    // SingleQuery
                    stringBuilder.append(CommonConstant.TRIBLE_TAB).append("AND").append(CommonConstant.SPACE).append(element)
                            .append("=").append("#{").append(element).append("}\n");
                }
                stringBuilder.append(CommonConstant.DOUBLE_TAB).append("</if>\n");
            } else {
                continue;
            }
            System.out.println(line);
        }

        // End
        stringBuilder.append("</select>");

        return stringBuilder.toString();
    }

}
