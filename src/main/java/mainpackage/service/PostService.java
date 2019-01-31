package mainpackage.service;

import mainpackage.dao.IPostDao;
import mainpackage.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by spire on 1/29/19.
 */
@Service
public class PostService implements IPostService{
    @Autowired
    private IPostDao postDao;

    @Override
    public Post create(Post post) {
        return this.postDao.create(post);
    }

    @Override
    public Post findById(long id) {
        return this.postDao.findById(id);
    }

    @Override
    public void delete(Post post) {
        this.postDao.delete(post);
    }

    @Override
    public List findAll() {
        return this.postDao.findAll();
    }
}
