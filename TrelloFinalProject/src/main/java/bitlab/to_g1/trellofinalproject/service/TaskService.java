package bitlab.to_g1.trellofinalproject.service;

import bitlab.to_g1.trellofinalproject.entity.Task;
import bitlab.to_g1.trellofinalproject.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CommentService commentService;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task addTaskToFolder(Task task) {
        task.setStatus(0);
        return taskRepository.save(task);
    }

    public List<Task> getTasksByFolderId(Long folderId) {
        return taskRepository.findTasksByFolderId(folderId);
    }


    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public String statusResult(Integer status) {
        if (status == 0) {
            return "TO DO";
        } else if (status == 1) {
            return "IN TEST";
        } else if (status == 2) {
            return "DONE";
        } else {
            return "FAILED";
        }
    }

    public Task editTaskStatus(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTaskById(Long taskId) {
        commentService.deleteCommentsFromTask(taskId);
        taskRepository.deleteById(taskId);
    }

    public void deleteTasksFromFolder(Long folderId) {
        List<Task> tasks = getTasksByFolderId(folderId);
        for (Task task : tasks) {
            commentService.deleteCommentsFromTask(task.getId());
        }
        taskRepository.deleteAllInBatch(tasks);
    }


}
