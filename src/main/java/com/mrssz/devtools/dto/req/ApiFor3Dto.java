package com.mrssz.devtools.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiFor3Dto {
    private Integer code;
    private String msg;
    private List<Map<String, Object>> data;
}
