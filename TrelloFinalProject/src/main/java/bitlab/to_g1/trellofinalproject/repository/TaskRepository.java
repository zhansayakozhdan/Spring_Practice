package bitlab.to_g1.trellofinalproject.repository;

import bitlab.to_g1.trellofinalproject.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t WHERE t.folder.id = :folderId")
    List<Task> findTasksByFolderId(Long folderId);
}
