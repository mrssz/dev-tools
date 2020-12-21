package com.mrssz.devtools.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MixNoteQueryDto {
    private List<Long> idList;
    private List<String> titleList;
    private List<String> authorList;
    private String content;

}
