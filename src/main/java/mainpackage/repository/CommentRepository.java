package mainpackage.repository;

import mainpackage.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by spire on 1/30/19.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
