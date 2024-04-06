package bitlab.to_g1.trellofinalproject.controller;

import bitlab.to_g1.trellofinalproject.entity.TaskCategory;
import bitlab.to_g1.trellofinalproject.exception.TrelloNotFoundException;
import bitlab.to_g1.trellofinalproject.service.TaskCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TaskCategoryController {
    @Autowired
    private TaskCategoryService taskCategoryService;

    @GetMapping("/task/categories")
    public String categoriesPage(Model model) {
        List<TaskCategory> categories = taskCategoryService.getAllTaskCategories();
        model.addAttribute("kategorii", categories);
        return "categories";
    }

    @GetMapping("/category/details/{id}")
    public String categoryDetails(@PathVariable Long id, Model model) throws TrelloNotFoundException {
        TaskCategory taskCategory = taskCategoryService.getCategoryById(id);
        model.addAttribute("category", taskCategory);
        return "categoryDetails";
    }

    @PostMapping("/category/add")
    public String addCategory(TaskCategory taskCategory) {
        taskCategoryService.createTaskCategory(taskCategory);
        return "redirect:/task/categories";
    }

}
