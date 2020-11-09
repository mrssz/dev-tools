package com.mrssz.devtools.controller;

import com.mrssz.devtools.dto.req.SwaggerDto;
import com.mrssz.devtools.service.SwaggerConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/swagger")
public class SwaggerController {
    @Autowired
    SwaggerConvertService swaggerService;

    @GetMapping("/index")
    public String swaggerIndex(Model model) {
        return "swagger/index";
    }

    @PostMapping("/index")
    public String swaggerIndexPost(ModelMap model, String source, String result, boolean camel, boolean data) {
        model.addAttribute("source", source);
        model.addAttribute("result", swaggerService.addSwagger(source, camel, data));
        return "swagger/index";
    }
}
