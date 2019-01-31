package mainpackage.controller;

import mainpackage.message.request.CommentForm;
import mainpackage.model.Comment;
import mainpackage.model.Like;
import mainpackage.model.User;
import mainpackage.service.ICommentService;
import mainpackage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by spire on 1/30/19.
 */
@Controller
@RequestMapping("/api/")
public class CommentController {
    @Autowired
    private UserService userService;

    @Autowired
    private ICommentService commentService;

    @PostMapping("comment")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Comment> create(@RequestBody CommentForm commentForm){
        User currentuser = this.userService.currentUser();
        Comment comment = new Comment(commentForm.getComment(),commentForm.getPost_id(),currentuser.getId(), 0);
        Comment return_comment = this.commentService.create(comment);
        return new ResponseEntity<Comment>(return_comment, HttpStatus.OK);
    }

    @DeleteMapping("comment/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable("id") long id){
        User currentuser = this.userService.currentUser();
        Comment comment = this.commentService.findById(id);
        User commentCreator = this.userService.findById(comment.getUser_id());
        if (this.userService.hasAdmin(currentuser) || currentuser.equals(commentCreator)){
            this.commentService.delete(comment);
            return new ResponseEntity<String>("The Comment deleted successfuly", HttpStatus.OK);
        }
        return new ResponseEntity<String>("error", HttpStatus.OK);
    }

    @PutMapping("comment/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Comment> edit(@PathVariable("id") long id,@RequestBody CommentForm commentForm){
        Comment comment = this.commentService.findById(id);
        User currentuser = this.userService.currentUser();
        User creator = this.userService.findById(comment.getUser_id());
        if (currentuser.equals(creator)){
            comment.setComment(commentForm.getComment());
            Comment return_comment = this.commentService.create(comment);
            return new ResponseEntity<Comment>(return_comment, HttpStatus.OK);
        }
        return new ResponseEntity<Comment>(new Comment(), HttpStatus.OK);
    }

    @GetMapping("comment/{id}/like")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Comment> like(@PathVariable("id") long id){
        User currentuser = this.userService.currentUser();
        Comment comment = this.commentService.findById(id);
        Like like = new Like(currentuser.getId(),comment.getId());
        Boolean add = true;
        for (Like l: comment.getLikes()) {
            if(l.equals(like)){
                add = false;
                break;
            }
        }
        Comment r_c;
        if (add){
            Like save_like = this.commentService.create(like);
            comment.addLikes(save_like);
            comment.setLike_count(comment.getLike_count() + 1);
            r_c = this.commentService.create(comment);
        }else {
            Set<Like> likes = this.commentService.delete(like, comment.getLikes());
            comment.setLikes(likes);
            comment.setLike_count(comment.getLike_count() - 1);
            r_c = this.commentService.create(comment);
        }
        return new ResponseEntity<Comment>(r_c, HttpStatus.OK);
    }
}
