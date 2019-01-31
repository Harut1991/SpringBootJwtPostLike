package mainpackage.dao;

import mainpackage.model.Post;
import mainpackage.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by spire on 1/29/19.
 */

@Transactional
@Repository
public class PostDao implements IPostDao {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Post create(Post post) {
        return this.postRepository.save(post);
    }

    @Override
    public Post findById(long id) {
        return this.postRepository.findById(id).get();
    }

    @Override
    public void delete(Post post) {
        this.postRepository.delete(post);
    }

    @Override
    public List findAll() {
        return this.postRepository.findAll();
    }
}
