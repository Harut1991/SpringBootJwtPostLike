package mainpackage.message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by spire on 1/30/19.
 */
public class CommentForm {
    @NotBlank
    @Size(max = 255)
    private String comment;

    @NotBlank
    private long post_id;

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
}
