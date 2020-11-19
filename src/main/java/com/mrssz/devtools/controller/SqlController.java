package com.mrssz.devtools.controller;

import com.mrssz.devtools.constant.CommonConstant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sql")
@Controller
public class SqlController {

    @GetMapping("/index")
    public String sqlIndex(Model model) {
        model.addAttribute("title", CommonConstant.TITLE_SQL);
        return "common/index";
    }

    @PostMapping("/index")
    public String sqlIndexPost(ModelMap model, String source, String result, boolean camel, boolean data) {
        model.addAttribute("title", CommonConstant.TITLE_SQL);
        model.addAttribute("source", source);
        return "common/index";
    }
}
