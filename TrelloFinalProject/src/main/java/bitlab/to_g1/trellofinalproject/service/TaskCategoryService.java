package bitlab.to_g1.trellofinalproject.service;

import bitlab.to_g1.trellofinalproject.entity.TaskCategory;
import bitlab.to_g1.trellofinalproject.exception.TrelloNotFoundException;
import bitlab.to_g1.trellofinalproject.repository.TaskCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TaskCategoryService {
    @Autowired
    private TaskCategoryRepository taskCategoryRepository;

    public List<TaskCategory> getAllTaskCategories() {
        return taskCategoryRepository.findAll();
    }

    public TaskCategory createTaskCategory(TaskCategory taskCategory) {
        return taskCategoryRepository.save(taskCategory);
    }

    public TaskCategory getTaskCategoryById(Long id) {
        return taskCategoryRepository.findById(id).orElse(null);
    }

    public TaskCategory getCategoryById(Long id) throws TrelloNotFoundException {
        String message = String.format("Task Category with ID: NOT FOUND", id);
        return taskCategoryRepository.findById(id)
                .orElseThrow(() -> new TrelloNotFoundException(message));
    }
}
