package bitlab.to_g1.trellofinalproject.service;

import bitlab.to_g1.trellofinalproject.entity.Comment;
import bitlab.to_g1.trellofinalproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public Comment addCommentToTask(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByTaskId(Long taskId) {
        return commentRepository.findAllByTaskId(taskId);
    }

    public void deleteCommentById(Long taskId, Long commentId) {
        Comment comment = getCommentById(commentId);
        if (comment.getTask().getId() != taskId) {
            return;
        } else
            commentRepository.delete(comment);
    }

    public void deleteCommentsFromTask(Long taskId) {
        List<Comment> comments = getCommentsByTaskId(taskId);
        commentRepository.deleteAllInBatch(comments);
    }
}
