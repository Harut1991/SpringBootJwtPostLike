package mainpackage.service;

import mainpackage.dao.ICommentDao;
import mainpackage.model.Comment;
import mainpackage.model.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by spire on 1/30/19.
 */
@Service
public class CommentService implements ICommentService{
    @Autowired
    private ICommentDao commentDao;

    @Override
    public Comment create(Comment comment) {
        return this.commentDao.create(comment);
    }

    @Override
    public Comment findById(long id) {
        return this.commentDao.findById(id);
    }

    @Override
    public void delete(Comment comment) {
        this.commentDao.delete(comment);
    }

    @Override
    public Like create(Like like) {
        return this.commentDao.create(like);
    }

    @Override
    public Set<Like> delete(Like like, Set<Like> list) {
        for (Like i:list){
            if (i.equals(like)){
                this.commentDao.delete(i);
                list.remove(i);
                break;
            }
        }
        return list;
    }


}
