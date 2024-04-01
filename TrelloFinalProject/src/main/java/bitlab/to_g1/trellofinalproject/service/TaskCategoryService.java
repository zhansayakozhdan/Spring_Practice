package bitlab.to_g1.trellofinalproject.service;

import bitlab.to_g1.trellofinalproject.entity.TaskCategory;
import bitlab.to_g1.trellofinalproject.repository.TaskCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCategoryService {
    @Autowired
    private TaskCategoryRepository taskCategoryRepository;

    public List<TaskCategory> getAllTaskCategories() {
        return taskCategoryRepository.findAll();
    }

    public TaskCategory createTaskCategory(TaskCategory taskCategory) {
        return taskCategoryRepository.save(taskCategory);
    }

    public TaskCategory getTaskCategoryById(Long id){
        return taskCategoryRepository.findById(id).orElse(null);
    }
}
