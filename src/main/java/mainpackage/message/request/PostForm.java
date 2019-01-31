package mainpackage.message.request;

import mainpackage.model.User;

import javax.persistence.EntityResult;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by spire on 1/29/19.
 */
public class PostForm {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotBlank
    @Size(min = 1, max=100)
    private String title;

    @NotBlank
    @Size(min = 1, max=200)
    private String description;

}
