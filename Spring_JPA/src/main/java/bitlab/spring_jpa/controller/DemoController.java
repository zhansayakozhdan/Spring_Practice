package bitlab.spring_jpa.controller;

import bitlab.spring_jpa.model.Developer;
import bitlab.spring_jpa.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DemoController {
    @Autowired
    private DeveloperService developerService;

    @GetMapping("/")
    public String homePage(Model model) {
        List<Developer> developers = developerService.getSortedDevelopers();
        model.addAttribute("developers", developers);
        return "home";
    }

    @PostMapping("/developer/add")
    public String addDeveloper(Developer developer) {
        developerService.addDeveloper(developer);
        return "redirect:/";
    }

    @GetMapping("/developer/{id}")
    public String detailsPage(@PathVariable Long id, Model model) {
        Developer developer = developerService.getDeveloperById(id);
        model.addAttribute("developer", developer);
        return "details";
    }

    @PostMapping("/developer/edit")
    public String editDeveloper(Developer developer) {
        developerService.editDeveloper(developer);
        return "redirect:/";
    }

    @GetMapping("/developer/search")
    public String search(@RequestParam String search, Model model) {
        List<Developer> developers = developerService.search(search);
        model.addAttribute("developers", developers);
        return "home";
    }
}

