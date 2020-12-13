package com.mrssz.devtools.service;

import com.mrssz.devtools.dto.req.ApiFor3Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class ApiFor3Service {
    @Autowired
    RestTemplate restTemplat;

    public String getMessage() {
        String url = "http://api.youngam.cn/api/one.php";
        ApiFor3Dto apiFor3Dto = restTemplat.getForObject(url, ApiFor3Dto.class);
        for (Map<String, Object> map : apiFor3Dto.getData()) {
            System.out.println(map);
        }
        return "";
    }

}
