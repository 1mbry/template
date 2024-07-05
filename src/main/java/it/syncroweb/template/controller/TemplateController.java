package it.syncroweb.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

    @GetMapping("/task")
    public String welcome(Model model) {
        model.addAttribute("info", "Welcome to Thymeleaf with Spring Boot!");
        return "task";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("info", "This is an about page with some information.");
        return "about";
    }
}
