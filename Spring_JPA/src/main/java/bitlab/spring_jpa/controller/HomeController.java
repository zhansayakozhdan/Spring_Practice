package bitlab.spring_jpa.controller;

import bitlab.spring_jpa.model.ApplicationRequest;
import bitlab.spring_jpa.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private RequestService requestService;
    @GetMapping("/")
    public String homePage(Model model){
        List<ApplicationRequest> requests = requestService.getAllRequests();
        model.addAttribute("zaprosy", requests);
        return "home";
    }

    @GetMapping("/app/request/add")
    public String addingPage(){
        return "addAppRequest";
    }

    @PostMapping("/request/add")
    public String addRequest(ApplicationRequest applicationRequest){
        requestService.addApplicationRequest(applicationRequest);
        return "redirect:/";
    }
}
