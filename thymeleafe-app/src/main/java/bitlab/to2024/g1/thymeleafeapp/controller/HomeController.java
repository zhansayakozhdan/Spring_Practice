package bitlab.to2024.g1.thymeleafeapp.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @GetMapping("/demo")
    public String demoPage(){
        return "demo";
    }
}
