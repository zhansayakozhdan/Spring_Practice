package bitlab.to_g1.trellofinalproject.repository;

import bitlab.to_g1.trellofinalproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
