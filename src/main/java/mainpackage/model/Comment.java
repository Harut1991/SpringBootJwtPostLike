package mainpackage.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by spire on 1/30/19.
 */
@Entity
@Table(name="comment")
public class Comment {
    public Comment(){}

    public Comment(String comment, long post_id, long user_id,long like_count) {
        this.comment = comment;
        this.post_id = post_id;
        this.user_id = user_id;
        this.like_count = like_count;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "post_id")
    private long post_id;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "like_count")
    private long like_count;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comment_id")
    Set<Like> likes = new HashSet();

    public Set<Like> getLikes() {
        return likes;
    }

    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }

    public void addLikes(Like like){ this.likes.add(like); }

    public long getLike_count() {
        return like_count;
    }

    public void setLike_count(long like_count) {
        this.like_count = like_count;
    }    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getPost_id() {
        return post_id;
    }

    public void setPost_id(long post_id) {
        this.post_id = post_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
