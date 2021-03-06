package mainpackage.dao;

import mainpackage.model.Post;

import java.util.List;

/**
 * Created by spire on 1/29/19.
 */
public interface IPostDao {
    Post create(Post post);
    Post findById(long id);
    void delete(Post post);
    List findAll();
}
