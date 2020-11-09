package com.mrssz.devtools.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwaggerDto {
    private String source;
    private String result;
    private boolean camel;
    private boolean data;
}
