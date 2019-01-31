package mainpackage.controller;

import mainpackage.message.request.PostForm;
import mainpackage.model.Post;
import mainpackage.model.User;
import mainpackage.service.IPostService;
import mainpackage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by spire on 1/29/19.
 */
@Controller
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private UserService userService;

    @Autowired
    private IPostService postService;

    @PostMapping("posts")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Post> create(@RequestBody PostForm postForm){
        User currentUser = this.userService.currentUser();
        Post post = new Post(postForm.getTitle(),postForm.getDescription(),currentUser.getId());
        Post return_post = this.postService.create(post);
        return new ResponseEntity<Post>(return_post, HttpStatus.OK);
    }

    @GetMapping("posts")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List> findAll(){
        List list = this.postService.findAll();
        return new ResponseEntity<List>(list, HttpStatus.OK);
    }

    @GetMapping("posts/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Post> findById(@PathVariable("id") long id){
        Post post = this.postService.findById(id);
        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

    @DeleteMapping("posts/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        User currentuser = this.userService.currentUser();
        Post post = this.postService.findById(id);
        if (this.userService.hasAdmin(currentuser)
                || currentuser.equals(this.userService.findById(post.getCreated_by()))){
            this.postService.delete(post);
            return new ResponseEntity<String>("The post deleted successfuly", HttpStatus.OK);
        }
        return new ResponseEntity<String>("error", HttpStatus.OK);
    }

}
