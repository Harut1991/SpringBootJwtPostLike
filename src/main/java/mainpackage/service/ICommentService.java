package mainpackage.service;

import mainpackage.model.Comment;
import mainpackage.model.Like;

import java.util.Set;

/**
 * Created by spire on 1/30/19.
 */
public interface ICommentService {
    Comment create(Comment comment);
    Comment findById(long id);
    void delete(Comment comment);
    Like create(Like like);
    Set<Like> delete(Like like, Set<Like> list);
}
