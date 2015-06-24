package by.abelski.microapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String getIndexPage(ModelMap model) {
        return "index";
    }
}