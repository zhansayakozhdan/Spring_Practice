package bitlab.to2024.g1.thymeleafeapp.controller;

import bitlab.to2024.g1.thymeleafeapp.model.Phone;
import bitlab.to2024.g1.thymeleafeapp.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping("/")
    public String homePage(Model model){
        List<Phone> phones =  phoneService.getSortedPhones();
        model.addAttribute("telefony", phones);
        return "home";
    }

    @GetMapping("/demo")
    public String demoPage(){
        return "demo";
    }

    @PostMapping("/phone/add")
    public String addPhone(Phone phone){
        phoneService.addPhone(phone);
        return "redirect:/";
    }
}
