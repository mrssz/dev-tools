package com.mrssz.devtools.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RawSwaggerDto {
    String name;
    Integer age;
    Date time;
    Object object;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InnerSwaggerDto {
        String innerName;
        Integer innerAge;
        Date innerTime;
        Object innerObject;
    }

}