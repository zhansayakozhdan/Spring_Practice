package bitlab.to_g1.trellofinalproject.controller;

import bitlab.to_g1.trellofinalproject.entity.Comment;
import bitlab.to_g1.trellofinalproject.entity.Task;
import bitlab.to_g1.trellofinalproject.service.CommentService;
import bitlab.to_g1.trellofinalproject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/task/details/{id}")
    public String taskDetailsPage(@PathVariable Long id, Model model){
        Task task = taskService.getTaskById(id);
        model.addAttribute("zadacha", task);

        List<Comment> comments = commentService.getCommentsByTaskId(task.getId());
        model.addAttribute("komenty", comments);
        return "taskDetails";
    }

    @PostMapping("/edit/task")
    public String editTaskStatus(Task task, Model model){
        Task editedTask = taskService.editTaskStatus(task);
        model.addAttribute("resultStatus", taskService.statusResult(editedTask.getStatus()));
        return "redirect:/task/details/"+task.getId();
    }

    @PostMapping("/add/comment/toTask")
    public String addCommentToTask(Comment comment){
        commentService.addCommentToTask(comment);
        return "redirect:/task/details/"+comment.getTask().getId();
    }

}
