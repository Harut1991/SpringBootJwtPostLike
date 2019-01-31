package mainpackage.repository;
import mainpackage.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by spire on 1/29/19.
 */
@Repository
public interface PostRepository  extends JpaRepository<Post, Long> {
}
