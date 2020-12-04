package com.mrssz.devtools.controller;

import com.mrssz.devtools.constant.CommonConstant;
import com.mrssz.devtools.service.SwaggerConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/swagger")
public class SwaggerController {
    @Autowired
    SwaggerConvertService swaggerService;

    @GetMapping("/index")
    public String swaggerIndex(Model model) {
        model.addAttribute("title", CommonConstant.TITLE_SWAGGER);
        return "common/index";
    }

    @PostMapping("/index")
    public String swaggerIndexPost(ModelMap model, String source, String result, boolean camel, boolean data,
                                   String prefix) {
        model.addAttribute("title", CommonConstant.TITLE_SWAGGER);
        model.addAttribute("source", source);
        model.addAttribute("result", swaggerService.addSwagger(source, camel, data, prefix));
        return "common/index";
    }
}
