package mainpackage.dao;

import mainpackage.model.Comment;
import mainpackage.model.Like;

/**
 * Created by spire on 1/30/19.
 */
public interface ICommentDao {
    Comment create(Comment comment);
    Comment findById(long id);
    void delete(Comment comment);
    Like create(Like like);
    void delete(Like like);
}
