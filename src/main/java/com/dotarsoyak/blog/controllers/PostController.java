package com.dotarsoyak.blog.controllers;

import com.dotarsoyak.blog.entities.Comment;
import com.dotarsoyak.blog.entities.Post;
import com.dotarsoyak.blog.models.PostRequest;
import com.dotarsoyak.blog.services.CommentService;
import com.dotarsoyak.blog.services.PostService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(path = "/post")
public class PostController {
    private static final Logger LOG = LoggerFactory.getLogger(PostController.class);
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/all")
    public ResponseEntity<List<Post>> findAll(){
        LOG.info("Start findAll Method.");

        List<Post> posts = this.postService.findAll();

        if(posts != null && posts.size() > 0){
            return ok(posts);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Post> save(@RequestBody @Valid PostRequest postRequest, UriComponentsBuilder ucb, BindingResult result){
        LOG.info("Receiving a post: {}", postRequest);

        var createdPost = this.postService.save(postRequest);

        URI location = ucb.path("/post/add/{id}")
                .buildAndExpand(createdPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/{id}/comment/add")
    public ResponseEntity<String> addComment(@PathVariable Long id
            , @RequestBody Comment comment, UriComponentsBuilder ucb){

        Optional<Post> post = this.postService.findById(id);
        Post updatedPost;

        if(post.isPresent()){
            updatedPost = post.get();
            var commentList = new ArrayList<Comment>();
            commentList.add(comment);

            updatedPost.setComments(commentList);
            this.postService.create(updatedPost);

            URI location = ucb.path("/post/{id}/comment/add")
                    .buildAndExpand(id)
                    .toUri();

            return ResponseEntity.created(location).build();
        }

        return ResponseEntity.created(URI.create("")).build();
    }

}
