package mainpackage.dao;

import mainpackage.model.Comment;
import mainpackage.model.Like;
import mainpackage.repository.CommentRepository;
import mainpackage.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by spire on 1/30/19.
 */
@Transactional
@Repository
public class CommentDao implements ICommentDao {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private LikeRepository likeRepository;

    @Override
    public Comment create(Comment comment) {
        return this.commentRepository.save(comment);
    }

    @Override
    public Comment findById(long id) {
        return this.commentRepository.findById(id).get();
    }

    @Override
    public void delete(Comment comment) {
        this.commentRepository.delete(comment);
    }

    @Override
    public Like create(Like like) {
        return this.likeRepository.save(like);
    }

    @Override
    public void delete(Like like) {
        this.likeRepository.delete(like);
    }
}
