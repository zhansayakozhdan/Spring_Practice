package bitlab.to_g1.trellofinalproject.controller;

import bitlab.to_g1.trellofinalproject.entity.Folder;
import bitlab.to_g1.trellofinalproject.entity.Task;
import bitlab.to_g1.trellofinalproject.entity.TaskCategory;
import bitlab.to_g1.trellofinalproject.service.FolderService;
import bitlab.to_g1.trellofinalproject.service.TaskCategoryService;
import bitlab.to_g1.trellofinalproject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private FolderService folderService;
    @Autowired
    private TaskCategoryService taskCategoryService;
    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String homePage(Model model) {
        List<Folder> folders = folderService.getAllFolders();
        model.addAttribute("folders", folders);
        return "home";
    }

    @PostMapping("/folder/add")
    public String addFolder(Folder folder) {
        folderService.createFolder(folder);
        return "redirect:/";
    }

    @GetMapping("/folder/details/{id}")
    public String folderDetailsPage(@PathVariable Long id, Model model) {
        Folder folder = folderService.getFolderById(id);
        model.addAttribute("papka", folder);

        List<TaskCategory> taskCategories = taskCategoryService.getAllTaskCategories();
        taskCategories.removeAll(folder.getTaskCategories());
        model.addAttribute("kategorii", taskCategories);

        List<Task> tasks = taskService.getTasksByFolderId(id);
        model.addAttribute("zadachi", tasks);
        return "folderDetails";
    }

    @PostMapping("/add/category/toFolder")
    public String addCategoryToFolder(@RequestParam Long folderId, @RequestParam Long taskCategoryId) {
        folderService.addCategoryToFolder(folderId, taskCategoryId);
        return "redirect:/folder/details/" + folderId;
    }

    @PostMapping("/delete/category/fromFolder")
    public String deleteCategoryFromFolder(@RequestParam Long folderId, @RequestParam Long taskCategoryId) {
        folderService.deleteCategoryFromFolder(folderId, taskCategoryId);
        return "redirect:/folder/details/" + folderId;
    }

    @PostMapping("/add/task/toFolder")
    public String addTaskToFolder(Task task) {
        taskService.addTaskToFolder(task);
        return "redirect:/folder/details/" + task.getFolder().getId();
    }

    @PostMapping("/delete/task/fromFolder")
    public String deleteTask(@RequestParam Long id) {
        taskService.deleteTaskById(id);
        return "redirect:/";
    }

    @PostMapping("/folder/delete")
    public String deleteFolder(@RequestParam Long id) {
        folderService.deleteFolderById(id);
        return "redirect:/";
    }
}
