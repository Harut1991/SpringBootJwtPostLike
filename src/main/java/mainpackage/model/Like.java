package mainpackage.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by spire on 1/30/19.
 */
@Entity
@Table(name = "comment_like")
public class Like implements Serializable{
    public Like(){}
    public Like(long user_id, long comment_id) {
        this.user_id = user_id;
        this.comment_id = comment_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "comment_id")
    private long comment_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getComment_id() {
        return comment_id;
    }

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }

    @Override
    public boolean equals(Object o) {
        if ( o == null || o == this || !(o instanceof Like) )
            return false;

        Like other = (Like) o;
        if (other.getComment_id() == this.getComment_id() && other.getUser_id() == this.getUser_id()){
            return true;
        }
        return false;
    }
}
