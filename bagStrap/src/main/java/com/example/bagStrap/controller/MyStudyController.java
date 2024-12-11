package com.example.bagStrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bagStrap")
public class MyStudyController {

	@RequestMapping("/mystudy/calendar") 
    public String calendar(Model model) throws Exception{

        return "study/calendar";

    }
}