package com.egx.citanda.web;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String getIndexPage(ModelMap model) {
        return "index";
    }

    @RequestMapping("tender")
    public String getTenderPage(ModelMap model) {
        return "index";
    }

    @RequestMapping("client")
    public String getClientPage(ModelMap model) {
        return "client";
    }

    @RequestMapping("login")
    public String getLoginPage(ModelMap map) {
        return "login";
    }

    @RequestMapping("error403")
    public String get403(ModelMap map) {
        return "error403";
    }
}