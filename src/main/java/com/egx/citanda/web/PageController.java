package com.egx.citanda.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/index")
    public String getLoginPage(ModelMap model) {
        return "index";
    }

    /*@RequestMapping("/index")
    public String getIndexPage(ModelMap model) {
        return "index";
    }*/
}