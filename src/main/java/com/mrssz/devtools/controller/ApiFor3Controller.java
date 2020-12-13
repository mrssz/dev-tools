package com.mrssz.devtools.controller;

import com.mrssz.devtools.service.ApiFor3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiFor3Controller {
    @Autowired
    ApiFor3Service for3Service;


    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String getMessage() {
        return for3Service.getMessage();
    }

}
