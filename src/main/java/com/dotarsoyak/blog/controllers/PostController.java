package com.dotarsoyak.blog.controllers;

import com.dotarsoyak.blog.entities.Post;
import com.dotarsoyak.blog.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(path = "/post")
public class PostController {
    private static final Logger LOG = LoggerFactory.getLogger(PostController.class);
    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public ResponseEntity<List<Post>> findAll(){
        LOG.info("Start findAll Method.");

        List<Post> posts = this.postService.findAll();

        if(posts != null && posts.size() > 0){
            return ResponseEntity.ok(posts);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<String> save(@RequestBody Post post, UriComponentsBuilder ucb){
        LOG.info("Receiving a post: {}", post);

        var createdPost = this.postService.save(post);

        URI location = ucb.path("/post/add/{id}")
                .buildAndExpand(createdPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


}
