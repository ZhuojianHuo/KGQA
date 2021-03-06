package com.imploded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imploded.service.QuestionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/imploded/question")
public class QuestionController {


    @Autowired
    QuestionService questionService;

    @RequestMapping("/query")
    public String query(@RequestParam(value = "question") String question) throws Exception {
        return questionService.answer(question);
    }
}
