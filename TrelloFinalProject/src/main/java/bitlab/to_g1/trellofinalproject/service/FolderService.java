package bitlab.to_g1.trellofinalproject.service;

import bitlab.to_g1.trellofinalproject.entity.Folder;
import bitlab.to_g1.trellofinalproject.entity.TaskCategory;
import bitlab.to_g1.trellofinalproject.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderService {
    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private TaskCategoryService taskCategoryService;

    @Autowired
    private TaskService taskService;

    public List<Folder> getAllFolders() {
        return folderRepository.findAll();
    }

    public Folder createFolder(Folder folder) {
        return folderRepository.save(folder);
    }

    public Folder getFolderById(Long id) {
        return folderRepository.findById(id).orElse(null);
    }

    public void addCategoryToFolder(Long folderId, Long taskCategoriesId) {
        Folder folder = getFolderById(folderId);
        TaskCategory taskCategory = taskCategoryService.getTaskCategoryById(taskCategoriesId);
        if (folder == null || taskCategory == null) {
            return;
        }

        List<TaskCategory> taskCategories = folder.getTaskCategories();
        taskCategories.add(taskCategory);

        folderRepository.save(folder);
    }

    public void deleteCategoryFromFolder(Long folderId, Long taskCategoryId) {
        Folder folder = getFolderById(folderId);
        TaskCategory taskCategory = taskCategoryService.getTaskCategoryById(taskCategoryId);
        if (folder == null || taskCategory == null) {
            return;
        }

        List<TaskCategory> taskCategories = folder.getTaskCategories();
        taskCategories.remove(taskCategory);

        folderRepository.save(folder);
    }

    public void deleteFolderById(Long folderId) {
        taskService.deleteTasksFromFolder(folderId);

        folderRepository.deleteById(folderId);
    }
}
