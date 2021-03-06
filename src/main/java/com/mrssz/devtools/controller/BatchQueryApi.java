package com.mrssz.devtools.controller;

import com.mrssz.devtools.constant.CommonConstant;
import com.mrssz.devtools.service.BatchQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/batch")
public class BatchQueryApi {
    @Autowired
    BatchQueryService queryService;

    @GetMapping("/index")
    public String batchIndex(Model model) {
        model.addAttribute("title", CommonConstant.TITLE_BATCH);
        return "batch/index";
    }

    @PostMapping("/index")
    public String batchIndexPost(ModelMap model, String source, String tableName, String resultType) {
        model.addAttribute("title", CommonConstant.TITLE_BATCH);
        model.addAttribute("source", source);
        model.addAttribute("controller", queryService.generateController(source, resultType));
        model.addAttribute("service", queryService.generateService(source, resultType));
        model.addAttribute("dao", queryService.generateDao(source, resultType));
        model.addAttribute("resultType", resultType);
        model.addAttribute("mapper", queryService.generateMapper(source, resultType, tableName));
        return "batch/index";
    }

}
