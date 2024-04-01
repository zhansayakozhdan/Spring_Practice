package bitlab.to_g1.trellofinalproject.repository;

import bitlab.to_g1.trellofinalproject.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
}
